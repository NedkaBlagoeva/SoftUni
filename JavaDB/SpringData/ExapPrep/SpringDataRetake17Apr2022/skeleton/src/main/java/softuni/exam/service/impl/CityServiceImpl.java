package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportCityDto;
import softuni.exam.models.entity.City;
import softuni.exam.repository.CityRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    public static final String CITY_FILE_PATH = "src/main/resources/files/json/cities.json";

    private final CityRepository cityRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CountryService countryService;

    public CityServiceImpl(CityRepository cityRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.countryService = countryService;
    }


    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITY_FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {
        ImportCityDto[] importCityDtos = gson.fromJson(readCitiesFileContent(), ImportCityDto[].class);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(importCityDtos).forEach(importCityDto -> {
            if (validationUtil.isValid(importCityDto)){
                City city = modelMapper.map(importCityDto, City.class);
                if (cityRepository.findByCityName(city.getCityName()).isEmpty()){
                    city.setCountry(countryService.findById(importCityDto.getCountry()).get());
                    cityRepository.save(city);
                    sb.append(String.format("Successfully imported city %s - %d", city.getCityName(), city.getPopulation()));
                } else {
                    sb.append("Invalid city");
                }
            } else {
                sb.append("Invalid city");
            }
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }
}

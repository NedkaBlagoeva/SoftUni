package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportCountryDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    public static final String COUNTRY_FILE_PATH = "src/main/resources/files/json/countries.json";

    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRY_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        ImportCountryDto[] importCountryDtos = gson.fromJson(readCountriesFromFile(), ImportCountryDto[].class);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(importCountryDtos).forEach(importCountryDto -> {
            if (validationUtil.isValid(importCountryDto)){
                Country country = modelMapper.map(importCountryDto, Country.class);
                if (countryRepository.findByCountryName(country.getCountryName()).isEmpty()){
                    countryRepository.save(country);
                    sb.append(String.format("Successfully imported country %s - %s", country.getCountryName(), country.getCurrency()));
                } else {
                    sb.append("Invalid country");
                }
            } else {
                sb.append("Invalid country");
            }
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }

    public Optional<Country> findById(Long id){
        return countryRepository.findById(id);
    }
}

package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportForecastRootDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DaysOfWeek;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class ForecastServiceImpl implements ForecastService {

    public static final String FORECAST_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";

    private final ForecastRepository forecastRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CityService cityService;

    public ForecastServiceImpl(ForecastRepository forecastRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, CityService cityService) {
        this.forecastRepository = forecastRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.cityService = cityService;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECAST_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        ImportForecastRootDto importForecastRootDto = xmlParser.fromFile(FORECAST_FILE_PATH, ImportForecastRootDto.class);
        StringBuilder sb = new StringBuilder();
        importForecastRootDto.getForecasts().forEach(importForecastDto -> {
            if (validationUtil.isValid(importForecastDto)) {
                Forecast forecast = modelMapper.map(importForecastDto, Forecast.class);
                City city = cityService.findById(importForecastDto.getCity()).get();
                if (forecastRepository.findByCityAndAndDaysOfWeek(city, importForecastDto.getDaysOfWeek()).isEmpty()){
                    forecast.setCity(city);
                    forecastRepository.save(forecast);
                    sb.append(String.format("Successfully import forecast %s - %.2f", forecast.getDaysOfWeek(), forecast.getMaxTemperature()));
                } else {
                    sb.append("Invalid forecast");
                }
            } else {
                sb.append("Invalid forecast");
            }
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }

    @Override
    public String exportForecasts() {
        StringBuilder sb = new StringBuilder();
        List<Forecast> forecasts = forecastRepository.export(DaysOfWeek.SUNDAY);
        forecasts.forEach(sb::append);
        return sb.toString();
    }
}

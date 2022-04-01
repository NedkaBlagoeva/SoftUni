package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportCarDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;

    public CarServiceImpl(CarRepository carRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validator) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/json/cars.json"));
    }

    @Override
    public String importCars() throws IOException {
        String json = this.readCarsFileContent();
        ImportCarDto[] importCarDtos = this.gson.fromJson(json, ImportCarDto[].class);
        List<String> result = new ArrayList<>();
        for (ImportCarDto importCarDto : importCarDtos) {
            if (validator.isValid(importCarDto)){
                Car car = modelMapper.map(importCarDto, Car.class);
                this.carRepository.save(car);
                result.add(String.format("Successfully imported car - %s - %s", car.getMake(), car.getModel()));

                //valid Successfully imported car - BMW - 750
            } else {
                result.add("Invalid Car");
            }
        }
        return String.join("\n", result);
    }

    @Override
    //todo
    public String getCarsOrderByPicturesCountThenByMake() {
        return null;
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);

    }
}

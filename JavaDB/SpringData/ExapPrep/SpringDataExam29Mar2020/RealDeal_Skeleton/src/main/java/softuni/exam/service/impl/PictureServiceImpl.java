package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportPictureDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final CarService carService;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PictureServiceImpl(PictureRepository pictureRepository, CarService carService, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.carService = carService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/json/pictures.json"));
    }

    @Override
    public String importPictures() throws IOException {
        String json = this.readPicturesFromFile();
        ImportPictureDto[] importPictureDtos = this.gson.fromJson(json, ImportPictureDto[].class);
        StringBuilder sb = new StringBuilder();
        for (ImportPictureDto importPictureDto : importPictureDtos) {
            if (validationUtil.isValid(importPictureDto)){
                Picture pic = modelMapper.map(importPictureDto, Picture.class);
                Car carById = carService.findById(importPictureDto.getCar());
                pic.setCar(carById);
                pictureRepository.save(pic);
                sb.append(String.format("Successfully import picture - %s", pic.getName()));
            } else {
                sb.append("Invalid picture");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

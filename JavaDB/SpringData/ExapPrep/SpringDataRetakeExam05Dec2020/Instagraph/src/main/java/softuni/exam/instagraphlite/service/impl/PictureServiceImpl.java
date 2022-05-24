package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.ImportPictureDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {

    public static final String PICTURES_FILE_PATH = "src/main/resources/files/pictures.json";

    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;


    public PictureServiceImpl(PictureRepository pictureRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        ImportPictureDto[] importPictureDtos = gson.fromJson(readFromFileContent(), ImportPictureDto[].class);
        StringBuilder sb = new StringBuilder();

        Arrays.stream(importPictureDtos).forEach(importPictureDto -> {
            if (validationUtil.isValid(importPictureDto)){
                Picture picture = modelMapper.map(importPictureDto, Picture.class);
                pictureRepository.save(picture);
                sb.append(String.format("Successfully imported Picture, with size %.2f", picture.getSize()));
            } else {
                sb.append("Invalid picture");
            }
            sb.append(System.lineSeparator());
        });

        return sb.toString();
    }

    @Override
    public String exportPictures() {
        return null;
    }

    @Override
    public Optional<Picture> findByPath(String path) {
        return pictureRepository.findByPath(path);
    }
}

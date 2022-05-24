package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.ImportUserDto;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    public static final String USER_FILE_PATH = "src/main/resources/files/users.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final PictureService pictureService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, PictureService pictureService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.pictureService = pictureService;
    }

    @Override
    public boolean areImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USER_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        ImportUserDto[] importUserDtos = gson.fromJson(readFromFileContent(), ImportUserDto[].class);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(importUserDtos).forEach(importUserDto -> {
            if (validationUtil.isValid(importUserDto)){
                User user = modelMapper.map(importUserDto, User.class);
                if (pictureService.findByPath(importUserDto.getProfilePicture()).isPresent()){
                    user.setPicture(pictureService.findByPath(importUserDto.getProfilePicture()).get());
                    userRepository.save(user);
                    sb.append(String.format("Successfully imported User: %s", user.getUsername()));
                } else {
                    sb.append("Invalid user");
                }
            } else {
                sb.append("Invalid user");
            }
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        return null;
    }

    @Override
    public Optional<User> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }
}

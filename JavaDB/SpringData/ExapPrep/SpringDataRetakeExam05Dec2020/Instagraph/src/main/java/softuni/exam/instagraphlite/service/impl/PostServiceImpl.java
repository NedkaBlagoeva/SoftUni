package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.ImportPostRootDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PostServiceImpl implements PostService {

    public static final String POST_FILE_PATH = "src/main/resources/files/posts.xml";

    private final PostRepository postRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PictureService pictureService;
    private final UserService userService;

    public PostServiceImpl(PostRepository postRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, PictureService pictureService, UserService userService) {
        this.postRepository = postRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.pictureService = pictureService;
        this.userService = userService;
    }

    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POST_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        ImportPostRootDto importPostRootDto = xmlParser.fromFile(POST_FILE_PATH, ImportPostRootDto.class);
        StringBuilder sb = new StringBuilder();
        for (var importPostDto : importPostRootDto.getPosts()) {

            if (validationUtil.isValid(importPostDto)) {
                Post post = modelMapper.map(importPostDto, Post.class);
                Picture picture = pictureService.findByPath(importPostDto.getPicture().getPath()).orElse(null);
                User user = userService.findByUsername(importPostDto.getUser().getUsername()).orElse(null);
                if (user != null && picture != null) {
                    post.setPicture(picture);
                    post.setUser(user);
                    postRepository.save(post);
                    sb.append(String.format("Successfully imported Post, made by %s", post.getUser().getUsername()));
                } else {
                    sb.append("Invalid post");
                }
            } else {
                sb.append("Invalid post");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

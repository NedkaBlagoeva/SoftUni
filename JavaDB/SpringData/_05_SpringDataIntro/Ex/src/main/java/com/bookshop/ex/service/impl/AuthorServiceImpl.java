package com.bookshop.ex.service.impl;

import com.bookshop.ex.model.entity.Author;
import com.bookshop.ex.repository.AuthorRepository;
import com.bookshop.ex.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private static final String AUTHORS_LOCATION = "src/main/resources/files/authors.txt";

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthor() throws IOException {

        Files.readAllLines(Path.of(AUTHORS_LOCATION))
                .stream()
                .map(row -> new Author(row.split("\\s+")[0], row.split("\\s+")[1]))
                .forEach(authorRepository::save);

    }

    @Override
    public Author getRandomAuthor() {
        long size = this.authorRepository.count();

        // 10 -> [0..9] -> [1..10]
        int authorId = new Random().nextInt((int) size) + 1;

        return this.authorRepository.findById((long) authorId).orElse(null);
    }

    @Override
    public List<Author> findAllAuthorsByBooksSize() {

        return authorRepository.findAuthorsByBooksSizeDESC();
    }
}

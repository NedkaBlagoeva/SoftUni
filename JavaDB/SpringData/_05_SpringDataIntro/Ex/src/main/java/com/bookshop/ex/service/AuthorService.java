package com.bookshop.ex.service;

import com.bookshop.ex.model.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthor() throws IOException;

    Author getRandomAuthor();
    List<Author> findAllAuthorsByBooksSize();
}

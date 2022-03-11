package com.bookshop.ex.service;

import com.bookshop.ex.model.entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBook() throws IOException;

    List<Book> findAllBooksAfterYear(int year);
    List<Book> findAllBooksAfterBefore(int year);
    List<Book> findAllByAuthorName(String name);

}

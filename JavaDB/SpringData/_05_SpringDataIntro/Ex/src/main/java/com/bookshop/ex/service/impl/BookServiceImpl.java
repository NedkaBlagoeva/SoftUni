package com.bookshop.ex.service.impl;

import com.bookshop.ex.repository.BookRepository;
import com.bookshop.ex.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void seedBook() {


    }
}

package com.bookshop.ex;

import com.bookshop.ex.service.AuthorService;
import com.bookshop.ex.service.BookService;
import com.bookshop.ex.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {

        seedData();

    }

    private void seedData() throws IOException {
        categoryService.seedCategory();
        authorService.seedAuthor();
        bookService.seedBook();
    }
}

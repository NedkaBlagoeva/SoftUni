package com.bookshop.ex;

import com.bookshop.ex.model.entity.Book;
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
        //printAllBooksAfterYear(2000);
        //printAllAuthorsWithBooksBeforeYear(1990);
        //printAuthorByNumberOfBooks();
        printAllBooksByAuthorName("George Powell");
    }

    private void printAllBooksByAuthorName(String authorName) {
        bookService
                .findAllByAuthorName(authorName)
                .forEach(book -> System.out.printf("%s %s %d%n",
                        book.getTitle(), book.getReleaseDate(), book.getCopies()));
    }

    private void printAuthorByNumberOfBooks() {
        authorService
                .findAllAuthorsByBooksSize()
                .forEach(author -> System.out.printf("%s %s - books count: %d%n",
                        author.getFirstName(), author.getLastName(), author.getBooks().size()));
    }

    private void printAllAuthorsWithBooksBeforeYear(int year) {
        bookService
                .findAllBooksAfterBefore(year)
                .stream()
                .map(book -> book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName())
                .distinct()
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream().map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategory();
        authorService.seedAuthor();
        bookService.seedBook();
    }
}

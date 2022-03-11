package com.bookshop.ex.service.impl;

import com.bookshop.ex.model.entity.Author;
import com.bookshop.ex.model.entity.Book;
import com.bookshop.ex.model.entity.Category;
import com.bookshop.ex.model.entity.enums.AgeRestriction;
import com.bookshop.ex.model.entity.enums.EditionType;
import com.bookshop.ex.repository.BookRepository;
import com.bookshop.ex.service.AuthorService;
import com.bookshop.ex.service.BookService;
import com.bookshop.ex.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private static final String BOOK_LOCATION = "src/main/resources/files/books.txt";
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBook() throws IOException {
        if(bookRepository.count() > 0){
            return;
        }

        Files.readAllLines(Path.of(BOOK_LOCATION))
                .forEach(row -> {
                    String[] data = row.split("\\s+");

                    Author author = authorService.getRandomAuthor();
                    EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
                    LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
                    int copies = Integer.parseInt(data[2]);
                    BigDecimal price = new BigDecimal(data[3]);
                    AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
                    String title = Arrays.stream(data).skip(5)
                            .collect(Collectors.joining(" "));
                    Set<Category> categories = categoryService.getRandomCategories();

                    Book book = new Book(title, editionType, price, releaseDate,
                            ageRestriction, author, categories, copies);

                    bookRepository.save(book);
                });


    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
       return bookRepository
               .findBookByReleaseDateAfter(LocalDate.of(2000,12,31));

    }

    @Override
    public List<Book> findAllBooksAfterBefore(int year) {
        return bookRepository
                .findBookByReleaseDateBefore(LocalDate.of(1990, 1 ,1 ));
    }

    @Override
    public List<Book> findAllByAuthorName(String name) {
        String [] authorInfo = name.split("\\s+");
        return bookRepository
                .findBooksByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitleAsc(authorInfo[0], authorInfo[1]);
    }
}

package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final Scanner scan;
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.scan = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        System.out.println("Enter exercise number (1-13): ");
        int exNum = Integer.parseInt(scan.nextLine());
        switch (exNum){
            case 1 -> task01BooksTitlesByAgeRestriction();
            case 2 -> task02GoldenBooks();
            case 3 -> task03BooksByPrice();
            case 4 -> task04NotReleasedBooks();
            case 5 -> task05BooksReleasedBeforeDate();
            case 6 -> task06AuthorsSearch();
            case 7 -> task07BooksSearch();
            case 8 -> task08BookTitlesSearch();
            case 9 -> task09CountBooks();

        }


//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

    }

    private void task09CountBooks() {


    }

    private void task08BookTitlesSearch() {

        System.out.println("Enter starting string: ");
        String startString = scan.nextLine();

        bookService
                .findAllByAuthorLastNameStartsWith(startString)
                .forEach(System.out::println);
    }

    private void task07BooksSearch() {

        System.out.println("Enter string: ");
        String string = scan.nextLine();

        bookService
                .findAllByTitleContains(string)
                .forEach(System.out::println);

    }

    private void task06AuthorsSearch() {

        System.out.println("Enter end-string: ");
        String endString = scan.nextLine();

        authorService
                .findAllByFirstNameEndsWith(endString)
                .forEach(System.out::println);
    }

    private void task05BooksReleasedBeforeDate() {

        System.out.println("Enter date: ");
        String input = scan.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate date = LocalDate.parse(input, formatter);

        bookService
                .findAllByReleaseDateBefore(date)
                .forEach(System.out::println);
    }

    private void task04NotReleasedBooks() {

        System.out.println("Enter year: ");
        int year = Integer.parseInt(scan.nextLine());

        bookService
                .findAllByReleaseDateBeforeOrReleaseDateAfter(year)
                .forEach(System.out::println);
    }

    private void task03BooksByPrice() {

        bookService
                .findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .forEach(System.out::println);
    }

    private void task02GoldenBooks() {

        bookService
                .findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .forEach(System.out::println);
    }

    private void task01BooksTitlesByAgeRestriction() {
        System.out.println("Enter age restriction (MINOR, TEEN, ADULT): ");
        String ageRestriction = scan.nextLine().toUpperCase();

        bookService
                .findAllByAgeRestriction(AgeRestriction.valueOf(ageRestriction))
                .forEach(System.out::println);
    }



    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}

package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<String> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2);

    List<String> findAllByReleaseDateBeforeOrReleaseDateAfter(int year);

    List<String> findAllByReleaseDateBefore(LocalDate releaseDate);

    List<String> findAllByTitleContains(String search);

    List<String> findAllByAuthorLastNameStartsWith(String authorLastName);

    int findAllByTitleLengthGreaterThan(int length);

    String findByTitle(String title);

    int addCopiesToBooksAfter(String date, int amount);

    int deleteAllByCopiesLessThan(Integer copies);

}

package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    //the titles of all books, for which the age restriction
    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    //the titles of the golden edition books, which have less than 5000 copies.
    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    //the titles and prices of books with price lower than 5 and higher than 40
    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2);

    //the titles of all books that are NOT released in a given year
    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findAllByTitleContains(String search);

    List<Book> findAllByAuthor_LastNameStartsWith(String authorLastName);

    @Query("SELECT b FROM Book b WHERE length(b.title) > :length")
    List<Book> findAllByTitleLengthGreaterThan(int length);

    Book findByTitle(String title);

    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.copies = b.copies + :amount WHERE b.releaseDate > :date")
    int addCopiesToBooksAfter(LocalDate date, int amount);

    //removes from the database those books, which copies are lower than a given number
    @Transactional
    int deleteAllByCopiesLessThan(Integer copies);


}

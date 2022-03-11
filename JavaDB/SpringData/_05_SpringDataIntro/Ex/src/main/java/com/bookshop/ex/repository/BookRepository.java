package com.bookshop.ex.repository;

import com.bookshop.ex.model.entity.Author;
import com.bookshop.ex.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBookByReleaseDateAfter(LocalDate releaseDate);

    List<Book> findBookByReleaseDateBefore(LocalDate releaseDate);

    List<Book> findBooksByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);
}
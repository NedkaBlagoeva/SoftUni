package com.bookshop.ex.repository;

import com.bookshop.ex.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC, a.firstName")
    List<Author> findAuthorsByBooksSizeDESC();

}

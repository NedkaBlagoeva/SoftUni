package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    List<Author> findAllByBooksSizeDESC();

    //first name ends with a given string.
    List<Author> findAllByFirstNameEndsWith(String endString);

    //prints the total number of book copies by author. Order the results descending by total book copies.
    @Query("SELECT sum(b.copies) FROM Author a JOIN Book b GROUP BY a.id")
    List<Author> findTotalBookCopies();


}

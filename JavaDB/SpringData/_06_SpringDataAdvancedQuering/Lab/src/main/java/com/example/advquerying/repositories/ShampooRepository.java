package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Repository
public interface ShampooRepository extends BaseRepository<Shampoo> {

    List<Shampoo> findAllBySizeOrderById(Size size);

    //given size or label id. Sort the result ascending by price.
    List<Shampoo> findAllBySizeOrLabel_IdOrderByPrice(Size size, Long labelId);

    //higher than a given price. Sort the result descending by price.
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    //counts all shampoos with price lower than a given price.
    List<Shampoo> findAllByPriceLessThan(BigDecimal price);

    //shampoos with ingredients included in a given list
    @Query ("SELECT s FROM Shampoo s JOIN s.ingredients i WHERE i.name IN :names")
    List<Shampoo> findAllByIngredientsIncluded(List<String> names);

    //shampoos with ingredients less than a given number
    @Query("SELECT s FROM Shampoo s WHERE s.ingredients.size < :number")
    List<Shampoo> findAllByTheNumberOfIngredientsLessThan(int number);
}

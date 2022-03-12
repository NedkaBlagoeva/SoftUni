package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;


public interface ShampooService {

    List<Shampoo> findAllBySizeOrderById(Size size);
    List<Shampoo> findAllBySizeOrLabel_IdOrderByPrice(Size size, Long label_id);
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
    Integer findAllByPriceLessThanCount(BigDecimal price);
    List<Shampoo> findAllByIngredientsIncluded(List<String> names);
    List<Shampoo> findAllByTheNumberOfIngredientsLessThan(int number);
}

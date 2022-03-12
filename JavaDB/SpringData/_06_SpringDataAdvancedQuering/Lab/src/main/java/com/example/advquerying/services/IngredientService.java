package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;

import java.util.Collection;
import java.util.List;

public interface IngredientService {

    List<Ingredient> findAllByNameStartingWith(String letters);
    List<Ingredient> findAllByNameInOrderByPrice(Collection<String> name);
    void deleteIngredientByName(String name);
    void updatePrice();
    void updatePriceByName(Collection<String> names);
}

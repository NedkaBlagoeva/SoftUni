package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface IngredientRepository extends BaseRepository<Ingredient> {
    //all ingredients, which name starts with given letters.
    List<Ingredient> findAllByNameStartingWith(String letters);
    List<Ingredient> findAllByNameInOrderByPrice(Collection<String> name);

    @Query("DELETE FROM Ingredient i WHERE i.name = :name")
    @Modifying
    void deleteIngredientByName(String name);

    @Query("UPDATE Ingredient i SET i.price = i.price * 1.1")
    @Modifying
    void updatePrice();

    @Query("UPDATE Ingredient i SET i.price = i.price * 1.1 WHERE i.name IN :names")
    @Modifying
    void updatePriceByName(Collection<String> names);
}

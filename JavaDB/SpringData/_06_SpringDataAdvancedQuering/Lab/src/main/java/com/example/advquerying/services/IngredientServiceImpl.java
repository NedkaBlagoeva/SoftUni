package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAllByNameStartingWith(String letters) {
        return ingredientRepository.findAllByNameStartingWith(letters);
    }

    @Override
    public List<Ingredient> findAllByNameInOrderByPrice(Collection<String> name) {
        return ingredientRepository.findAllByNameInOrderByPrice(name);
    }

    @Override
    @Transactional
    public void deleteIngredientByName(String name) {
        ingredientRepository.deleteIngredientByName(name);
    }

    @Override
    @Transactional
    public void updatePrice() {
        ingredientRepository.updatePrice();
    }

    @Override
    @Transactional
    public void updatePriceByName(Collection<String> names) {
        ingredientRepository
                .updatePriceByName(names);
    }
}

package com.bookshop.ex.service.impl;

import com.bookshop.ex.model.entity.Category;
import com.bookshop.ex.repository.CategoryRepository;
import com.bookshop.ex.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private static final String CATEGORIES_LOCATION = "src/main/resources/files/categories.txt";

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategory() throws IOException {

        if (categoryRepository.count() > 0){
            return;
        }

        Files.readAllLines(Path.of(CATEGORIES_LOCATION))
                .stream().filter(row -> !row.isEmpty())
                .forEach(categoryName -> {
                    Category category = new Category(categoryName);
                    categoryRepository.save(category);

                });

    }
}

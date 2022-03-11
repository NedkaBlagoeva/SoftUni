package com.bookshop.ex.service;

import com.bookshop.ex.model.entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategory() throws IOException;

    Set<Category> getRandomCategories();
}

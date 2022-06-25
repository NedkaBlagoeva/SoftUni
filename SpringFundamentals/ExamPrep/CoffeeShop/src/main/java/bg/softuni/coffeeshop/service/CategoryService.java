package bg.softuni.coffeeshop.service;

import bg.softuni.coffeeshop.model.entity.Category;
import bg.softuni.coffeeshop.model.enums.CategoryEnum;
import org.springframework.stereotype.Service;
import bg.softuni.coffeeshop.repository.CategoryRepository;

import java.util.Arrays;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void initializeDB(){
        if (categoryRepository.count() != 0){
            return;
        }

        Arrays.stream(CategoryEnum.values())
                .forEach(categoryEnum -> {
                    Category category = new Category();
                    category.setName(categoryEnum);
                    switch (categoryEnum) {
                        case Drink -> category.setNeededTime(1);
                        case Coffee -> category.setNeededTime(2);
                        case Cake -> category.setNeededTime(10);
                        case Other -> category.setNeededTime(5);
                    }
                    categoryRepository.save(category);
                });
    }
}

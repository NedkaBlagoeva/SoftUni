package bg.softuni.coffeeshop.model.entity;

import bg.softuni.coffeeshop.model.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @Column(nullable = false)
    private int neededTime;

    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public int getNeededTime() {
        return neededTime;
    }

    public void setNeededTime() {
        switch (name) {
            case Drink -> this.neededTime = 1;
            case Coffee -> this.neededTime = 2;
            case Cake -> this.neededTime = 10;
            case Other -> this.neededTime = 5;
        }
    }
}

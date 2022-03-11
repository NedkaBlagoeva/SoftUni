package com.bookshop.ex.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "categories")
public class Category extends BaseEntity{

    @Column (nullable = false)
    private String name;


    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

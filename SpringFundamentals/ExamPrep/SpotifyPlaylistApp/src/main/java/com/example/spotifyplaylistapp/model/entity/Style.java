package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.enums.StyleEnum;

import javax.persistence.*;

@Entity
@Table(name="styles")
public class Style extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private StyleEnum styleName;

    @Column
    private String description;

    public StyleEnum getStyleName() {
        return styleName;
    }

    public void setStyleName(StyleEnum styleName) {
        this.styleName = styleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

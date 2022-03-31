package com.example.football.models.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ImportTownDto {
    @Min(value = 2, message = "Invalid town")
    private String name;

    @Positive(message = "Invalid town")
    private int population;

    @Size(min = 10)
    private String travelGuide;

    public ImportTownDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getTravelGuide() {
        return travelGuide;
    }

    public void setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
    }
}

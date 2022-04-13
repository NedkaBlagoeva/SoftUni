package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "towns")
public class Town extends BaseEntity{

    @Column(name = "town_name", unique = true, updatable = false)
    private String townName;

    @Column(nullable = false)
    private Integer population;

    public Town() {
    }


    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}

package entities;

import javax.persistence.Entity;

@Entity
public class Truck extends Vehicle{

    private Double loadCapacity;

    public Truck() {

    }

    public Truck(Double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(Double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}

package entities;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {

    private Integer seats;

    public Car(Integer seats) {
        this.seats = seats;
    }

    public Car() {

    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}

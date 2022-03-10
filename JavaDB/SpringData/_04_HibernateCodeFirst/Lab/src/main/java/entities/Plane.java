package entities;

import javax.persistence.Entity;

@Entity
public class Plane extends Vehicle{

    private Integer passengerCapacity;

    public Plane() {
    }

    public Plane(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}

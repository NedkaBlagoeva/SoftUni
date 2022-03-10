package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
public class Bike extends Vehicle{
    private static String type = "Bike";

    public Bike() {

    }
}

import entities.Car;
import entities.Truck;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        EntityManager em = Persistence
                .createEntityManagerFactory("SoftUni")
                .createEntityManager();

        em.getTransaction().begin();
        Car car = new Car();
        car.setType("Car");
        em.persist(car);
        Truck truck = new Truck(230.0);
        em.persist(truck);
        em.getTransaction().commit();
    }
}

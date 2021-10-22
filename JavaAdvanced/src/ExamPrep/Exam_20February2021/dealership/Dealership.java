package ExamPrep.Exam_20February2021.dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {

    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        return data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        out.append("The cars are in a car ExamPrep.Exam_20February2021.dealership ").append(name).append(":").append(System.lineSeparator());
        data.forEach(c -> out.append(c).append(System.lineSeparator()));
        return out.toString().trim();
    }
}

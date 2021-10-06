package _06_DefiningClasses.Lab._02_CarConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String brand = input[0];
            switch (input.length) {
                case 1:
                    Car car = new Car(brand);
                    cars.add(car);
                    break;
                case 3:
                    String model = input[1];
                    int horsePower = Integer.parseInt(input[2]);
                    Car car1 = new Car(brand, model, horsePower);
                    cars.add(car1);
                    break;
            }
        }
        cars.forEach(Car::carInfo);
    }
}

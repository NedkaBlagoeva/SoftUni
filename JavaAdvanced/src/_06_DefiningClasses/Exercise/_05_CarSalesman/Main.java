package _06_DefiningClasses.Exercise._05_CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Car's weight, color, its Engine’s displacements, and efficiency are optional
        int engineCount = Integer.parseInt(scan.nextLine());
        Map<String, Engine> engines = new HashMap<>();
        for (int i = 0; i < engineCount; i++) {
            String[] input = scan.nextLine().split("\\s+");
            //"{Model} {Power} {Displacement} {Efficiency}
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            Engine engine = null;
            switch (input.length) {
                case 2: {
                    engine = new Engine(model, power);
                    break;
                }
                case 4: {
                    int displacement = Integer.parseInt(input[2]);
                    String efficiency = input[3];
                    engine = new Engine(model, power, displacement, efficiency);
                    break;
                }
                case 3:
                    try {
                        int displacement = Integer.parseInt(input[2]);
                        engine = new Engine(model, power, displacement);
                    } catch (NumberFormatException e) {
                        String efficiency = input[2];
                        engine = new Engine(model, power, efficiency);
                    }
                    break;
            }
            engines.put(model, engine);

        }
        int carCount = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            String[] input = scan.nextLine().split("\\s+");
            //"{Model} {Engine} {Weight} {Color}
            String carModel = input[0];
            Engine carEngine = engines.get(input[1]);
            Car car = null;
            switch (input.length) {
                case 2:
                    car = new Car(carModel, carEngine);
                    break;
                case 4:
                    int carWeight = Integer.parseInt(input[2]);
                    String carColor = input[3];
                    car = new Car(carModel, carEngine, carWeight, carColor);
                    break;
                case 3:
                    try {
                        int carWeight1 = Integer.parseInt(input[2]);
                        car = new Car(carModel, carEngine, carWeight1);
                    } catch (NumberFormatException e) {
                        String carColor1 = input[2];
                        car = new Car(carModel, carEngine, carColor1);
                    }
                    break;
                default:
                    break;
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}

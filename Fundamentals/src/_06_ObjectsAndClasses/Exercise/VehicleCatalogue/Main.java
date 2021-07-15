package _06_ObjectsAndClasses.Exercise.VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();

        while (!"End".equals(command)) {
            String[] commandSplit = command.split("\\s+");
            String type = commandSplit[0];
            String model = commandSplit[1];
            String color = commandSplit[2];
            int hp = Integer.parseInt(commandSplit[3]);
            Vehicle vehicle = new Vehicle(type, model, color, hp);
            vehicles.add(vehicle);
            command = scan.nextLine();
        }
        String model = scan.nextLine();
        while (!"Close the Catalogue".equals(model)) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(model)) {
                    System.out.println(vehicle);
                }
            }
            model = scan.nextLine();
        }
        int countCars = 0;
        int countTruck = 0;
        int sumTruckHp = 0;
        int sumCarHp = 0;
        for (int i = 0; i < vehicles.size(); i++) {
            switch (vehicles.get(i).getType()) {
                case "truck":
                    countTruck++;
                    sumTruckHp += vehicles.get(i).getHp();
                    break;
                case "car":
                    countCars++;
                    sumCarHp += vehicles.get(i).getHp();
                    break;
                default:
                    break;
            }
        }
        if (countCars == 0) {
            System.out.println("Cars have average horsepower of: 0.00.");
        } else {
            double avgCarHp = sumCarHp * 1.0 / countCars;
            System.out.printf("Cars have average horsepower of: %.2f.%n", avgCarHp);
        }
        if (countTruck == 0) {
            System.out.println("" +
                    "Trucks have average horsepower of: 0.00.");
        } else {
            double avgTruckHp = sumTruckHp * 1.0 / countTruck;
            System.out.printf("Trucks have average horsepower of: %.2f.", avgTruckHp);
        }
    }
}

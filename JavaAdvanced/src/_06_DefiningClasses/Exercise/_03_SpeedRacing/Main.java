package _06_DefiningClasses.Exercise._03_SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] carInfo = scan.nextLine().split("\\s+");
            //{Model} {FuelAmount} {FuelCostFor1km}
            String model = carInfo[0];
            double fuelAmount = Double.parseDouble(carInfo[1]);
            double fuelCost = Double.parseDouble(carInfo[2]);
            Car car = new Car(model, fuelAmount, fuelCost);
            cars.putIfAbsent(model, car);
        }
        String command = scan.nextLine();
        while (!command.equals("End")) {
            String[] commands = command.split("\\s+"); //"Drive {CarModel} {amountOfKm}"
            String carModel = commands[1];
            double amountOfKm = Double.parseDouble(commands[2]);
            if (!cars.get(carModel).canDrive(amountOfKm)) {
                System.out.println("Insufficient fuel for the drive");
            }
            command = scan.nextLine();
        }
        cars
                .forEach((key, value) -> System.out.printf("%s %.2f %.0f%n", value.getModel(), value.getFuelAmount(), value.getDistanceTraveled()));
    }
}

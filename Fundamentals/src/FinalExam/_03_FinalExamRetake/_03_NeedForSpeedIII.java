package FinalExam._03_FinalExamRetake;

import java.util.*;

public class _03_NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scan.nextLine());
        Map<String, CarInfo> cars = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] carInfo = scan.nextLine().split("\\|");
            String carName = carInfo[0];
            int mileage = Integer.parseInt(carInfo[1]);
            int fuel = Integer.parseInt(carInfo[2]);
            cars.put(carName, new CarInfo(mileage, fuel));
        }
        String inputForCommands = scan.nextLine();
        while (!"Stop".equals(inputForCommands)) {
            String[] commands = inputForCommands.split(" : ");
            String commandWord = commands[0];
            String carName = commands[1];
            switch (commandWord) {
                case "Drive":
                    int distance = Integer.parseInt(commands[2]);
                    int fuelNeeded = Integer.parseInt(commands[3]);
                    int currentFuel = cars.get(carName).getFuel();
                    if (currentFuel < fuelNeeded) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        int currentMileage = cars.get(carName).getMileage();
                        cars.get(carName).setMileage(currentMileage + distance);
                        cars.get(carName).setFuel(currentFuel - fuelNeeded);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carName, distance, fuelNeeded);
                    }
                    if (cars.get(carName).getMileage() >= 100000) {
                        cars.remove(carName);
                        System.out.println("Time to sell the " + carName + "!");
                    }
                    break;
                case "Refuel":
                    int fuelToRefuel = Integer.parseInt(commands[2]);
                    int fuelToFill = 75 - cars.get(carName).getFuel(); // 75 - currentFuel
                    if (fuelToFill < fuelToRefuel) {
                        cars.get(carName).setFuel(75);
                        System.out.printf("%s refueled with %d liters%n", carName, fuelToFill);
                    } else {
                        cars.get(carName).setFuel(cars.get(carName).getFuel() + fuelToRefuel);
                        System.out.printf("%s refueled with %d liters%n", carName, fuelToRefuel);
                    }
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(commands[2]);
                    int currentMileage = cars.get(carName).getMileage();
                    cars.get(carName).setMileage(currentMileage - kilometers);
                    if (cars.get(carName).getMileage() < 10000) {
                        cars.get(carName).setMileage(10000);
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", carName, kilometers);
                    }
                    break;
                default:
                    break;
            }
            inputForCommands = scan.nextLine();
        }
        cars.entrySet().stream().sorted((m1, m2) -> {
            int result = Integer.compare(m2.getValue().getMileage(), m1.getValue().getMileage());
            if (result == 0) {
                result = m1.getKey().compareTo(m2.getKey());
            }
            return result;
        }).forEach(car -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                car.getKey(), car.getValue().getMileage(), car.getValue().getFuel()));
    }

    public static class CarInfo {
        private int mileage;
        private int fuel;

        public CarInfo(int mileage, int fuel) {
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }
    }
}

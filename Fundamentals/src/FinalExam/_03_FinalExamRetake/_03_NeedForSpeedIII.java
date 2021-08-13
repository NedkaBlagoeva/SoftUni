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
                    if (currentFuel < fuelNeeded){
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        int currentMileage = cars.get(carName).getMileage();
                        cars.get(carName).setMileage(currentMileage + distance);
                        cars.get(carName).setFuel(currentFuel - distance);
                    }
                    if (cars.get(carName).getMileage() >= 100000){
                        cars.remove(carName);
                        System.out.println("Time to sell the car " + carName);
                    }
                    break;
                case "Refuel":
                    int fuelToRefuel = Integer.parseInt(commands[2]);

                    break;
                case "Revert":
                    break;
                default:
                    break;
            }
            inputForCommands = scan.nextLine();
        }
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

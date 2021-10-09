package _06_DefiningClasses.Exercise._04_RawData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        //"{Model}
        // {EngineSpeed} {EnginePower}
        // {CargoWeight} {CargoType}
        // {Tire1Pressure} {Tire1Age} {Tire2Pressure} {Tire2Age}
        // {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}"
        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            Tire tyre1 = new Tire(tire1Pressure, tire1Age);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            Tire tyre2 = new Tire(tire2Pressure, tire2Age);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            Tire tyre3 = new Tire(tire3Pressure, tire3Age);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);
            Tire tyre4 = new Tire(tire4Pressure, tire4Age);
            Car car = new Car(model, engine, cargo, tyre1, tyre2, tyre3, tyre4);
            cars.put(model, car);
        }
        String command = scan.nextLine();
        switch (command) {
            case "fragile":
                //tire whose pressure is  < 1
                printFragile(cars);
                break;
            case "flamable":
                //have Engine Power > 250
                printFlammable(cars);
                break;
            default:
                break;
        }

    }

    public static void printFragile(Map<String, Car> cars){
        cars.entrySet()
                .stream()
                .filter(e -> e.getValue().getCargo().getType().equals("fragile"))
                .filter(e -> e.getValue().getTire1().getPressure() < 1 ||
                        e.getValue().getTire2().getPressure() < 1 ||
                        e.getValue().getTire3().getPressure() < 1 ||
                        e.getValue().getTire4().getPressure() < 1)
                .forEach(e -> System.out.println(e.getKey()));
    }

    public static void printFlammable (Map<String, Car> cars){
        cars.entrySet()
                .stream()
                .filter(e -> e.getValue().getCargo().getType().equals("flamable"))
                .filter(e -> e.getValue().getEngine().getPower() > 250)
                .forEach(e -> System.out.println(e.getKey()));
    }
}

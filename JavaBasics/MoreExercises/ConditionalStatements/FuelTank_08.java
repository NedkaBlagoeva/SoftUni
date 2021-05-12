package MoreExercises.ConditionalStatements;

import java.util.Locale;
import java.util.Scanner;

public class FuelTank_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String fuelType = scan.nextLine();
        double fuelLitres = Double.parseDouble(scan.nextLine());

        //"Diesel", "Gasoline" или "Gas",
        if (fuelLitres >= 25) {
            switch (fuelType) {
                case "Diesel":
                case "Gasoline":
                case "Gas":
                    System.out.printf("You have enough %s.", fuelType.toLowerCase(Locale.ROOT));
                    break;
                default:
                    System.out.println("Invalid fuel!");
            }
        } else {
            switch (fuelType) {
                case "Diesel":
                case "Gasoline":
                case "Gas":
                    System.out.printf("Fill your tank with %s!", fuelType.toLowerCase(Locale.ROOT));
                    break;
                default:
                    System.out.println("Invalid fuel!");

            }
        }
    }
}

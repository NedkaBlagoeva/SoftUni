package MoreExercises.ConditionalStatementsAdvanced;

import java.util.Scanner;

public class CarToGo_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String classType = "";
        double carPrice = 0.0;
        String carType = "";

        if (budget <= 100) {
            classType = "Economy class";
            switch (season) {
                case "Summer":
                    carType = "Cabrio";
                    carPrice = 0.35 * budget;
                    break;
                case "Winter":
                    carType = "Jeep";
                    carPrice = 0.65 * budget;
                    break;
            }

        } else if (budget <= 500) {
            classType = "Compact class";
            switch (season) {
                case "Summer":
                    carType = "Cabrio";
                    carPrice = 0.45 * budget;
                    break;
                case "Winter":
                    carType = "Jeep";
                    carPrice = 0.80 * budget;
                    break;
            }
        } else {
            classType = "Luxury class";
            switch (season) {
                case "Summer":
                case "Winter":
                    carType = "Jeep";
                    carPrice = 0.90 * budget;
                    break;
            }
        } System.out.printf("%s%n%s - %.2f", classType, carType, carPrice);
    }
}

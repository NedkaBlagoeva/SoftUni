package MoreExercises.ConditionalStatementsAdvanced;

import java.util.Scanner;

public class Vacation_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String tripType = "";
        double tripPrice = 0.0;
        String location = "";

        if (budget <= 1000) {
            tripType = "Camp";
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    tripPrice = 0.65 * budget;
                    break;
                case "Winter":
                    location = "Morocco";
                    tripPrice = 0.45 * budget;
                    break;
            }
        } else if (budget <= 3000) {
            tripType = "Hut";
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    tripPrice = 0.80 * budget;
                    break;
                case "Winter":
                    location = "Morocco";
                    tripPrice = 0.60 * budget;
                    break;
            }
        } else {
            tripType = "Hotel";
            tripPrice = 0.90 * budget;
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    break;
                case "Winter":
                    location = "Morocco";
                    break;
            }
        }
        System.out.printf("%s - %s - %.2f", location, tripType, tripPrice);
    }

}

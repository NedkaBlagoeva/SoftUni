package MoreExercises.ConditionalStatements;

import java.util.Scanner;

public class FuelTankPart2_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String fuelType = scan.nextLine();
        double fuelLiters = Double.parseDouble(scan.nextLine());
        String card = scan.nextLine();

        double gasolinePrice = 2.22;
        double dieselPrice = 2.33;
        double gasPrice = 0.93;
        double finalPrice = 0.0;


        if ("Gasoline".equals(fuelType)) {
            switch (card) {
                case "Yes":
                    finalPrice = fuelLiters * gasolinePrice;
                    finalPrice -= fuelLiters * 0.18;
                    break;
                case "No":
                    finalPrice = fuelLiters * gasolinePrice;
                    break;
            }

        } else if ("Diesel".equals(fuelType)) {
            finalPrice = fuelLiters * dieselPrice;
            switch (card) {

                case "Yes":
                    finalPrice -= fuelLiters * 0.12;
                    break;
            }

        } else if ("Gas".equals(fuelType)) {
            finalPrice = fuelLiters * gasPrice;
            switch (card) {
                case "Yes":
                    finalPrice -= fuelLiters * 0.08;
                    break;
            }
        }
        if (fuelLiters >= 20 && fuelLiters <= 25) {
            finalPrice *= 0.92;

        } else if (fuelLiters > 25) {
            finalPrice *= 0.90;
        }
        System.out.printf("%.2f lv.", finalPrice);
    }
}

package MoreExercises.ConditionalStatements;

import java.util.Scanner;

public class Harvest_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int area = Integer.parseInt(scan.nextLine());
        double grapeForMeter = Double.parseDouble(scan.nextLine());
        int wineNeeded = Integer.parseInt(scan.nextLine());
        int workers = Integer.parseInt(scan.nextLine());

        double wineProduced = area * grapeForMeter / 2.5 * 0.4;
        double littersLeft = Math.abs(wineProduced-wineNeeded);

        if (wineProduced < wineNeeded) {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(littersLeft));
        } else if (wineProduced >= wineNeeded){
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n %.0f liters left -> %.0f liters per person.",
                    Math.floor(wineProduced), Math.ceil(littersLeft), Math.ceil(littersLeft / workers));
        }
    }
}

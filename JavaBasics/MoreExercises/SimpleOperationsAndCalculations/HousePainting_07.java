package MoreExercises.SimpleOperationsAndCalculations;

import java.util.Scanner;

public class HousePainting_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double x = Double.parseDouble(scan.nextLine());
        double y = Double.parseDouble(scan.nextLine());
        double h = Double.parseDouble(scan.nextLine());

        double greenArea = 2 * x * x + 2 * x * y - 2 * 1.5 * 1.5 - 1.2 * 2;
        double greenPaintNeeded = greenArea / 3.4;

        double redArea = x * y * 2 + h * x;
        double redPaintNeeded = redArea / 4.3;

        System.out.printf("%.2f%n", greenPaintNeeded);
        System.out.printf("%.2f", redPaintNeeded);


    }
}

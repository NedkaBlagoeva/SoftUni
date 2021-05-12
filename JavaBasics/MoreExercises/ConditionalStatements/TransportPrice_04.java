package MoreExercises.ConditionalStatements;

import java.util.Scanner;

public class TransportPrice_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int km = Integer.parseInt(scan.nextLine());
        String partOfTheDay = scan.nextLine();
        double price;
        if (km >= 100) {
            price = 0.06 * km;
            System.out.printf("%.2f", price);
        } else if (km >= 20) {
            price = 0.09 * km;
            System.out.printf("%.2f", price);
        } else {
            if (partOfTheDay.equals("day")) {
                price = 0.70 + 0.79 * km;
                System.out.printf("%.2f", price);
            } else if (partOfTheDay.equals("night")) {
                price = 0.70 + 0.90 * km;
                System.out.printf("%.2f", price);
            }
        }


    }
}

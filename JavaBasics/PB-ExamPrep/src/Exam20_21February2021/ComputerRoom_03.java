package Exam20_21February2021;

import java.util.Scanner;

public class ComputerRoom_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String month = scan.nextLine();
        int hours = Integer.parseInt(scan.nextLine());
        int group = Integer.parseInt(scan.nextLine());
        String partOfTheDay = scan.nextLine();
        double price = 0.0;

        // "march", "april", "may", "june", "july", "august"
        switch (month) {
            case "march":
            case "april":
            case "may":
                switch (partOfTheDay) {
                    case "day":
                        price = 10.50;
                        break;
                    case "night":
                        price = 8.40;
                        break;
                }
                break;
            case "june":
            case "july":
            case "august":
                switch (partOfTheDay) {
                    case "day":
                        price = 12.60;
                        break;
                    case "night":
                        price = 10.20;
                        break;
                }
                break;
        }
        if (group >= 4) {
            price *= 0.90;
        }
        if (hours >= 5) {
            price *= 0.50;
        }
        double totalPrice = price * group * hours;
        System.out.printf("Price per person for one hour: %.2f\n", price);
        System.out.printf("Total cost of the visit: %.2f", totalPrice);
    }
}

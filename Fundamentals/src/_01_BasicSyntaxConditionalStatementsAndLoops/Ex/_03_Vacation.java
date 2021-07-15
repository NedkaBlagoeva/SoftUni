package _01_BasicSyntaxConditionalStatementsAndLoops.Ex;

import java.util.Scanner;

public class _03_Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scan.nextLine());
        String peopleType = scan.nextLine();
        String day = scan.nextLine();
        double price = 0.0;

        switch (day) {
            case "Friday":
                switch (peopleType) {
                    case "Students":
                        price = 8.45;
                        break;
                    case "Business":
                        price = 10.90;
                        break;
                    case "Regular":
                        price = 15.00;
                        break;
                }
                break;
            case "Saturday":
                switch (peopleType) {
                    case "Students":
                        price = 9.80;
                        break;
                    case "Business":
                        price = 15.60;
                        break;
                    case "Regular":
                        price = 20.00;
                        break;
                }
                break;
            case "Sunday":
                switch (peopleType) {
                    case "Students":
                        price = 10.46;
                        break;
                    case "Business":
                        price = 16.00;
                        break;
                    case "Regular":
                        price = 22.50;
                        break;
                }
                break;
        }
        double totalPrice = peopleCount * price;
        if (peopleCount >= 30 && peopleType.equals("Students")) {
            totalPrice *= 0.85;
        }
        if (peopleCount >= 100 && peopleType.equals("Business")) {
            totalPrice = (peopleCount - 10) * price;
        }
        if (peopleCount >= 10 && peopleCount <= 20 && peopleType.equals("Regular")) {
            totalPrice *= 0.95;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}

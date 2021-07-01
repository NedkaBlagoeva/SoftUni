package _01_FundamentalsMidExamRetake;

import java.util.Scanner;

public class _01_ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        boolean isSpecial = false;
        double totalPrice = 0;
        while (true) {
            if ("regular".equals(input)) {
                break;
            }
            if ("special".equals(input)) {
                isSpecial = true;
                break;
            }
            double partPrice = Double.parseDouble(input);
            if (partPrice <= 0) {
                System.out.println("Invalid price!");
            } else {
                totalPrice += partPrice;
            }
            input = scan.nextLine();
        }
        double taxes = totalPrice * 0.2;
        double finalPrice = totalPrice * 1.2;
        if (isSpecial) {
            finalPrice = totalPrice * 1.2 * 0.9;
        }

        if (totalPrice == 0) {
            System.out.println("Invalid order!");
            return;
        }
        printReceipt(totalPrice, taxes, finalPrice);
    }

    private static void printReceipt(double totalPrice, double taxes, double finalPrice) {
        System.out.printf("Congratulations you've just bought a new computer!\n" +
                "Price without taxes: %.2f$\n" +
                "Taxes: %.2f$\n" +
                "-----------\n" +
                "Total price: %.2f$\n", totalPrice, taxes, finalPrice);
    }

}

package _01_FundamentalsMidExamRetake;

import java.util.Scanner;

public class _01_ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        boolean isRegular = false;
        boolean isSpecial = false;
        double totalPrice = 0;
        while (true) {
            if ("regular".equals(input)) {
                isRegular = true;
                break;
            }
            if ("special".equals(input)) {
                isSpecial = true;
                break;
            }
            double partPrice = Double.parseDouble(input);

            if (partPrice <= 0) {
                System.out.println("Invalid price!");
            }else{
                totalPrice += partPrice;
            }

            input = scan.nextLine();
        }
        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else if (isRegular) {
            System.out.printf("Congratulations you've just bought a new computer!\n" +
                    "Price without taxes: %.2f$\n" +
                    "Taxes: %.2f$\n" +
                    "-----------\n" +
                    "Total price: %.2f$\n", totalPrice, totalPrice * 0.2, totalPrice * 1.2);
        } else if (isSpecial) {
            System.out.printf("Congratulations you've just bought a new computer!\n" +
                    "Price without taxes: %.2f$\n" +
                    "Taxes: %.2f$\n" +
                    "-----------\n" +
                    "Total price: %.2f$\n", totalPrice, totalPrice * 0.2, totalPrice * 1.2 * 0.9);
        }
    }
}

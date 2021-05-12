package MoreExercises.WhileLoop;

import java.util.Scanner;

public class ReportSystem_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sumNeeded = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int count = 0;
        boolean isInvalid = false;
        int cardSum = 0;
        int cardCount = 0;
        int cashSum = 0;
        int cashCount = 0;
        boolean isEnough = false;

        while (!input.equals("End")) {
            int price = Integer.parseInt(input);
            count++;
            if (count % 2 != 0) { //cash
                if (price > 100) {
                    System.out.println("Error in transaction!");
                    input = scan.nextLine();
                    continue;
                }
                cashCount++;
                cashSum += price;
                System.out.println("Product sold!");
            } else { //card
                if (price < 10) {
                    System.out.println("Error in transaction!");
                    input = scan.nextLine();
                    continue;
                }
                cardCount++;
                cardSum += price;
                System.out.println("Product sold!");
            }
            if (cashSum + cardSum >= sumNeeded) {
                isEnough = true;
                break;
            }
            input = scan.nextLine();
        }
        if (isEnough) {
            System.out.printf("Average CS: %.2f\n" +
                    "Average CC: %.2f\n", cashSum * 1.0 / cashCount, cardSum * 1.0 / cardCount);
        } else {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}

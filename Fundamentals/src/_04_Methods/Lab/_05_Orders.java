package _04_Methods.Lab;

import java.util.Scanner;

public class _05_Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        int quantity = Integer.parseInt(scan.nextLine());
        printOrderSum(product, quantity);
    }

    private static void printOrderSum(String product, int quantity) {
        double price = 0;
        switch (product) {
            case "coffee":
                price = 1.50;
                break;
            case "water":
                price = 1.00;
                break;
            case "coke":
                price = 1.40;
                break;
            case "snacks":
                price = 2.00;
                break;
        }
        System.out.printf("%.2f", price * quantity);
    }
}

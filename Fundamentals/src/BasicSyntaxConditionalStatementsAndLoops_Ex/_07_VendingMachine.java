package BasicSyntaxConditionalStatementsAndLoops_Ex;

import java.util.Scanner;

public class _07_VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double moneySum = 0;

        while (!input.equals("Start")) {
            double moneyIn = Double.parseDouble(input);
            if (moneyIn == 0.1 || moneyIn == 0.2 || moneyIn == 0.5 || moneyIn == 1 || moneyIn == 2) {
                moneySum += moneyIn;
            } else {
                System.out.printf("Cannot accept %.2f%n", moneyIn);
            }

            input = scan.nextLine();
        }
        String product = scan.nextLine();
        while (!product.equals("End")) {
            switch (product) {
                case "Nuts":
                    if (moneySum >= 2.0) {
                        moneySum -= 2.0;
                        System.out.println("Purchased Nuts");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (moneySum >= 0.7) {
                        moneySum -= 0.7;
                        System.out.println("Purchased Water");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (moneySum >= 1.5) {
                        moneySum -= 1.5;
                        System.out.println("Purchased Crisps");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (moneySum >= 0.8) {
                        moneySum -= 0.8;
                        System.out.println("Purchased Soda");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (moneySum >= 1.0) {
                        moneySum -= 1.0;
                        System.out.println("Purchased Coke");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
            }
            product = scan.nextLine();
        }
        System.out.printf("Change: %.2f",moneySum);
    }
}

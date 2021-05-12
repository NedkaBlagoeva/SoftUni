package ConditionalStatementsAdvanced_Exercise;

import java.util.Scanner;

public class NewHouse_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String flowersType = scan.nextLine();
        int flowers = Integer.parseInt(scan.nextLine());
        int budget = Integer.parseInt(scan.nextLine());
        double price = 0.0;
        double totalCost = 0.0;
        switch (flowersType) {
            case "Roses":
                price = 5.00;
                if (flowers > 80) {
                    totalCost = price * flowers * 0.90;
                } else {
                    totalCost = price * flowers;
                }
                break;
            case "Dahlias":
                price = 3.80;
                if (flowers > 90) {
                    totalCost = price * flowers * 0.85;
                } else {
                    totalCost = price * flowers;
                }
                break;
            case "Tulips":
                price = 2.80;
                if (flowers > 80) {
                    totalCost = price * flowers * 0.85;
                } else {
                    totalCost = price * flowers;
                }
                break;
            case "Narcissus":
                price = 3.00;
                if (flowers < 120) {
                    totalCost = price * flowers * 1.15;
                } else {
                    totalCost = price * flowers;
                }
                break;
            case "Gladiolus":
                price = 2.50;
                if (flowers < 80) {
                    totalCost = flowers * price * 1.20;
                } else {
                    totalCost = flowers * price;
                }
                break;
        }
        if (budget >= totalCost) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowers, flowersType, budget - totalCost);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", totalCost - budget);
        }

    }
}

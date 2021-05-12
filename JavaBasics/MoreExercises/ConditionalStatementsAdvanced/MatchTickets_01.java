package MoreExercises.ConditionalStatementsAdvanced;

import java.util.Scanner;

public class MatchTickets_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String category = scan.nextLine();
        int people = Integer.parseInt(scan.nextLine());

        double transport = 0.0;
        double ticketPrice = 0.0;
        double allExpenses = 0.0;

        if (people <= 4) {
            transport = budget * 0.75;
        } else if (people <= 9) {
            transport = budget * 0.6;
        } else if (people <= 24) {
            transport = budget * 0.5;
        } else if (people <= 49) {
            transport = budget * 0.4;
        } else {
            transport = budget * 0.25;
        }
        switch (category) {
            case "Normal":
                ticketPrice = 249.99;
                break;
            case "VIP":
                ticketPrice = 499.99;
                break;
        }
        allExpenses = transport + ticketPrice * people;
        if (budget >= allExpenses) {
            System.out.printf("Yes! You have %.2f leva left.", budget - allExpenses);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", allExpenses - budget);
        }
    }
}

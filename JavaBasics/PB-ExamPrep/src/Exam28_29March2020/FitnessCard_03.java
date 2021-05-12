package Exam28_29March2020;

import java.util.Scanner;

public class FitnessCard_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double money = Double.parseDouble(scan.nextLine());
        String gender = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String sport = scan.nextLine();
        double price = 0.0;

        switch (gender){
            case "m":
                switch (sport){
                    case "Gym":
                        price = 42.00;
                        break;
                    case "Boxing":
                        price = 41.00;
                        break;
                    case "Yoga":
                        price = 45.00;
                        break;
                    case "Zumba":
                        price = 34.00;
                        break;
                    case "Dances":
                        price = 51.00;
                        break;
                    case "Pilates":
                        price = 39.00;
                        break;
                }
                break;
            case "f":
                switch (sport){
                    case "Gym":
                        price = 35.00;
                        break;
                    case "Boxing":
                    case "Pilates":
                        price = 37.00;
                        break;
                    case "Yoga":
                        price = 42.00;
                        break;
                    case "Zumba":
                        price = 31.00;
                        break;
                    case "Dances":
                        price = 53.00;
                        break;
                }
                break;
        }
        if (age < 19){
            price *= 0.80;
        }
        if (money >= price){
            System.out.printf("You purchased a 1 month pass for %s.", sport);
        } else {
            System.out.printf("You don't have enough money! You need $%.2f more.", price - money);
        }
    }
}

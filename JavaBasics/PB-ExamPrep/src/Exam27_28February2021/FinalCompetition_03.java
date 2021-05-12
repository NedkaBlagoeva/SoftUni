package Exam27_28February2021;

import java.util.Scanner;

public class FinalCompetition_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dancers = Integer.parseInt(scan.nextLine());
        double points = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String destination = scan.nextLine();
        double price = 0.0;

        switch (destination){
            case "Bulgaria":
                price = points * dancers;
                switch (season){
                    case "summer":
                        price *= 0.95;
                        break;
                    case "winter":
                        price *= 0.92;
                        break;
                }
                break;
            case "Abroad":
                price = points * dancers + (points * dancers) / 2;
                switch (season){
                    case "summer":
                        price *= 0.90;
                        break;
                    case "winter":
                        price *= 0.85;
                        break;
                }
                break;
        }
        double sumForCharity = price * 0.75;
        double sumPerDancer = price * 0.25 / dancers;
        System.out.printf("Charity - %.2f\n", sumForCharity);
        System.out.printf("Money per dancer - %.2f\n", sumPerDancer);

    }
}

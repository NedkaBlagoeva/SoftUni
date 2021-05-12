package MoreExercises.ConditionalStatementsAdvanced;

import java.util.Scanner;

public class TruckDriver1_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String season = scan.nextLine();
        double kmPerMonth = Double.parseDouble(scan.nextLine());
        double salary = 0.0;
        double pricePerKm = 0.0;

        switch (season){
            case "Spring":
            case "Autumn":
                if (kmPerMonth <= 5000){
                    pricePerKm = 0.75;
                }else if (kmPerMonth <= 10000){
                    pricePerKm = 0.95;
                }else if (kmPerMonth <= 20000){
                    pricePerKm = 1.45;
                }
                break;
            case "Summer":
                if (kmPerMonth <= 5000){
                    pricePerKm = 0.90;
                }else if (kmPerMonth <= 10000){
                    pricePerKm = 1.10;
                }else if (kmPerMonth <= 20000){
                    pricePerKm = 1.45;
                }
                break;
            case "Winter":
                if (kmPerMonth <= 5000){
                    pricePerKm = 1.05;
                }else if (kmPerMonth <= 10000){
                    pricePerKm = 1.25;
                }else if (kmPerMonth <= 20000){
                    pricePerKm = 1.45;
                }
                break;
        } salary = kmPerMonth*pricePerKm *4;
        salary *= 0.90;
        System.out.printf("%.2f",salary);
    }
}

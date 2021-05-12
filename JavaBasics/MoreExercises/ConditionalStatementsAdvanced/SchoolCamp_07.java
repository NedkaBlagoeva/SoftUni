package MoreExercises.ConditionalStatementsAdvanced;

import java.util.Scanner;

public class SchoolCamp_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String season = scan.nextLine();
        String groupType = scan.nextLine();
        int students = Integer.parseInt(scan.nextLine());
        int nights = Integer.parseInt(scan.nextLine());
        double pricePerNight = 0.0;
        String sport = "";

        switch (season) {
            case "Winter":
                switch (groupType) {
                    case "girls":
                        pricePerNight = 9.60;
                        sport = "Gymnastics";
                        break;
                    case "boys":
                        pricePerNight = 9.60;
                        sport = "Judo";
                        break;
                    case "mixed":
                        pricePerNight = 10.0;
                        sport = "Ski";
                        break;
                }
                break;
            case "Summer":
                switch (groupType) {
                    case "girls":
                        pricePerNight = 15.0;
                        sport = "Volleyball";
                        break;
                    case "boys":
                        pricePerNight = 15.0;
                        sport = "Football";
                        break;
                    case "mixed":
                        pricePerNight = 20.0;
                        sport = "Swimming";
                        break;
                }
                break;
            case "Spring":
                switch (groupType) {
                    case "girls":
                        pricePerNight = 7.20;
                        sport = "Athletics";
                        break;
                    case "boys":
                        pricePerNight = 7.20;
                        sport = "Tennis";
                        break;
                    case "mixed":
                        pricePerNight = 9.50;
                        sport = "Cycling";
                        break;
                }
                break;
        }if (students >= 50){
            pricePerNight *= 0.50;
        }else if (students >= 20){
            pricePerNight *= 0.85;
        }else if (students >= 10){
            pricePerNight *= 0.95;
        }
        System.out.printf("%s %.2f lv.", sport, pricePerNight*students*nights);
    }
}

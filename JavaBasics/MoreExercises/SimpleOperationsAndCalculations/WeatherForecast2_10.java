package MoreExercises.SimpleOperationsAndCalculations;

import java.util.Scanner;

public class WeatherForecast2_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double grads = Double.parseDouble(scan.nextLine());
//        26.00 - 35.00	Hot
//        20.10 - 25.90	Warm
//        15.00 - 20.00	Mild
//        12.00 - 14.90	Cool
//        05.00 - 11.90	Cold

        if (grads >= 26 && grads <= 35) {
            System.out.println("Hot");
        }
        else if (grads >= 20.10 && grads <= 25.90) {
            System.out.println("Warm");
        }
        else if (grads >= 15.00 && grads <= 20.00) {
            System.out.println("Mild");
        }
        else if (grads >= 12 && grads <= 14.9) {
            System.out.println("Cool");
        }
        else if (grads >= 5 && grads <= 11.9) {
            System.out.println("Cold");
        }
        else {
            System.out.println("unknown");
        }
    }
}

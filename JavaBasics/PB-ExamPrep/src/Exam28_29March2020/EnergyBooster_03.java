package Exam28_29March2020;

import java.util.Scanner;

public class EnergyBooster_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String fruit = scan.nextLine();
        String setSize = scan.nextLine();
        int setCount = Integer.parseInt(scan.nextLine());
        double price = 0.0;
//                              Диня 	        Манго	        Ананас	        Малина
//        2 броя (small)	    56 лв./бр.	    36.66 лв./бр.	42.10 лв./бр.	20 лв./бр.
//        5 броя (big)	        28.70 лв./бр.	19.60 лв./бр.	24.80 лв./бр.	15.20 лв./бр.

        switch (fruit) {
            case "Watermelon":
                switch (setSize) {
                    case "small":
                        price = 2 * 56.00;
                        break;
                    case "big":
                        price = 5 * 28.70;
                        break;
                }
                break;
            case "Mango":
                switch (setSize) {
                    case "small":
                        price = 2 * 36.66;
                        break;
                    case "big":
                        price = 5 * 19.60;
                        break;
                }
                break;
            case "Pineapple":
                switch (setSize) {
                    case "small":
                        price = 2 * 42.10;
                        break;
                    case "big":
                        price = 5 * 24.80;
                        break;
                }
                break;
            case "Raspberry":
                switch (setSize) {
                    case "small":
                        price = 2 * 20.00;
                        break;
                    case "big":
                        price = 5 * 15.20;
                        break;
                }
                break;
        }price = price * setCount;
        if (price >= 400 && price <= 1000){
            price *= 0.85;
        }else if (price >= 1000){
            price *= 0.50;
        }
        System.out.printf("%.2f lv.", price);
    }
}

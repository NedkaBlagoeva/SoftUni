package _07_FundamentalsMidExam10July2021;

import java.util.Scanner;

public class _01_Problem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double quantityFood = Double.parseDouble(scan.nextLine()) * 1000;
        double quantityHay = Double.parseDouble(scan.nextLine()) * 1000;
        double quantityCover = Double.parseDouble(scan.nextLine()) * 1000;
        double pigWeight = Double.parseDouble(scan.nextLine()) * 1000;
        boolean isFoodEnough = true;

        for (int i = 1; i <= 30; i++) {

            if (quantityFood >= 300) {
                quantityFood -= 300;
            } else {
                isFoodEnough = false;
                break;
            }
            if (i % 2 == 0) {
                if (quantityHay >=  quantityFood * 5 / 100) {
                    quantityHay -= quantityFood * 5 / 100;
                } else {
                    isFoodEnough = false;
                    break;
                }
            }
            if (i % 3 == 0) {
                if (quantityCover >= pigWeight / 3) {
                    quantityCover -= pigWeight / 3;
                } else {
                    isFoodEnough = false;
                    break;
                }

            }
        }
        if (isFoodEnough) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", quantityFood / 1000, quantityHay / 1000, quantityCover / 1000);
        } else {
            System.out.print("Merry must go to the pet store!");
        }
    }
}

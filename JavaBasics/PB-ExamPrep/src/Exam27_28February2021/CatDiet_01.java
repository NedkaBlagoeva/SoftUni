package Exam27_28February2021;

import java.util.Scanner;

public class CatDiet_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int fatsPr = Integer.parseInt(scan.nextLine());
        int proteinsPr = Integer.parseInt(scan.nextLine());
        int carbsPr = Integer.parseInt(scan.nextLine());
        int calories = Integer.parseInt(scan.nextLine());
        int waterPr = Integer.parseInt(scan.nextLine());

        double fats = fatsPr * calories * 0.01 / 9;
        double proteins = proteinsPr * calories * 0.01 / 4;
        double carbs = carbsPr * calories * 0.01 / 4;

        double weight = fats + proteins + carbs;
        double caloriesPerGram = calories / weight;
        double result = caloriesPerGram * (100 - waterPr) / 100;

        System.out.printf("%.4f", result);
    }
}

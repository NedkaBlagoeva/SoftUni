package MoreExercises.ConditionalStatements;

import java.util.Scanner;

public class Pets_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        int food = Integer.parseInt(scan.nextLine());
        double dogFoodPerDay = Double.parseDouble(scan.nextLine());
        double catFoodPerDay = Double.parseDouble(scan.nextLine());
        double turtleFoodPerDay = Double.parseDouble(scan.nextLine()) / 1000;

        double neededFood = days * (dogFoodPerDay + catFoodPerDay + turtleFoodPerDay);

        if (neededFood <= food) {
            System.out.printf("%.0f kilos of food left.", Math.floor(food - neededFood));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(neededFood - food));
        }


    }

}

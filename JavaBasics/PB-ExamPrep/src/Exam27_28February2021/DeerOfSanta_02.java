package Exam27_28February2021;

import java.util.Scanner;

public class DeerOfSanta_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        int foodKg = Integer.parseInt(scan.nextLine());
        double foodDeer1 = Double.parseDouble(scan.nextLine());
        double foodDeer2 = Double.parseDouble(scan.nextLine());
        double foodDeer3 = Double.parseDouble(scan.nextLine());

        double neededFood = (foodDeer1 + foodDeer2 + foodDeer3) * days;
        if (foodKg >= neededFood){
            System.out.printf("%.0f kilos of food left.", Math.floor(foodKg - neededFood));
        }else{
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(neededFood - foodKg));
        }

    }
}
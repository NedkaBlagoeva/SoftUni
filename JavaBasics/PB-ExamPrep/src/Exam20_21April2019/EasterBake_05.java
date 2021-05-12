package Exam20_21April2019;

import java.util.Scanner;

public class EasterBake_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countSweetBread = Integer.parseInt(scan.nextLine());
        int maxSugar = 0;
        int maxFlour = 0;
        int allSugarNeeded = 0;
        int allFlourNeeded = 0;

        for (int i = 1; i <= countSweetBread; i++) {
            int sugar = Integer.parseInt(scan.nextLine());
            int flour = Integer.parseInt(scan.nextLine());
            allSugarNeeded += sugar;
            allFlourNeeded += flour;

            if (flour > maxFlour) {
                maxFlour = flour;
            }
            if (sugar > maxSugar) {
                maxSugar = sugar;
            }

        }
        double flourPacks = Math.ceil(allFlourNeeded * 1.0 / 750);
        double sugarPacks = Math.ceil(allSugarNeeded * 1.0 / 950);
        System.out.printf("Sugar: %.0f\n", sugarPacks);
        System.out.printf("Flour: %.0f\n", flourPacks);
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.", maxFlour, maxSugar);

    }
}

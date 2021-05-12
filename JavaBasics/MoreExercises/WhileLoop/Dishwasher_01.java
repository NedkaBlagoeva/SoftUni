package MoreExercises.WhileLoop;

import java.util.Scanner;

public class Dishwasher_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cleaningAgent = Integer.parseInt(scan.nextLine()) * 750;
        String input = scan.nextLine();
        int count = 0;
        int dishCount = 0;
        int potCount = 0;
        boolean isOver = false;
        while (!input.equals("End")) {
            count++;
            int dishes = Integer.parseInt(input);
            if (count % 3 != 0) {
                dishCount += dishes;
                cleaningAgent -= dishes * 5;
            } else {
                potCount += dishes;
                cleaningAgent -= dishes * 15;
            }
            if (cleaningAgent < 0) {
                isOver = true;
                break;
            }
            input = scan.nextLine();
        }
        if (isOver) {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(cleaningAgent));
        } else {
            System.out.printf("Detergent was enough!\n" +
                    "%d dishes and %d pots were washed.\n" +
                    "Leftover detergent %d ml.\n", dishCount, potCount, cleaningAgent);
        }
    }
}

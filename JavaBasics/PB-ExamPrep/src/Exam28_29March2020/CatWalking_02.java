package Exam28_29March2020;

import java.util.Scanner;

public class CatWalking_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int minutesForWalk = Integer.parseInt(scan.nextLine());
        int walksPerDay = Integer.parseInt(scan.nextLine());
        int caloriesPerDay = Integer.parseInt(scan.nextLine());
        int caloriesBurned = walksPerDay * minutesForWalk * 5;
        if (caloriesBurned >= caloriesPerDay * 1.0/2) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", caloriesBurned);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", caloriesBurned);
        }
    }
}

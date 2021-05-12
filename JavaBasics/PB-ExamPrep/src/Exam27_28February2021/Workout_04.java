package Exam27_28February2021;

import java.util.Scanner;

public class Workout_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int daysN = Integer.parseInt(scan.nextLine());
        double kilometers = Double.parseDouble(scan.nextLine());
        double sum = 0.0;

        for (int i = 1; i <= daysN; i++) {
            sum += kilometers;
            int increasePr = Integer.parseInt(scan.nextLine());
            kilometers += increasePr * kilometers / 100;

        }
        sum += kilometers;
        if (sum >= 1000) {
            System.out.printf("You've done a great job running %.0f more kilometers!", Math.ceil(sum - 1000));
        } else {
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", Math.ceil(Math.abs(1000 - sum)));
        }
    }
}

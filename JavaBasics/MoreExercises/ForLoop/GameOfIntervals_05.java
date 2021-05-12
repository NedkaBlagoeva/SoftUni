package MoreExercises.ForLoop;

import java.util.Scanner;

public class GameOfIntervals_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double countTo9 = 0;
        double countTo19 = 0;
        double countTo29 = 0;
        double countTo39 = 0;
        double countTo50 = 0;
        double countInvalid = 0;
        double all = 0;

        for (int i = 0; i < n; i++) {
            double num = Integer.parseInt(scan.nextLine());
            if (num >= 0 && num <= 9) {
                countTo9++;
                all += num * 0.20;
            } else if (num >= 10 && num <= 19) {
                countTo19++;
                all += num * 0.30;
            } else if (num >= 20 && num <= 29) {
                countTo29++;
                all += num * 0.40;
            } else if (num >= 30 && num <= 39) {
                countTo39++;
                all += 50;
            } else if (num >= 40 && num <= 50) {
                countTo50++;
                all += 100;
            } else {
                countInvalid++;
                all /= 2;
            }

        }
        System.out.printf("%.2f\n", all);
        System.out.printf("From 0 to 9: %.2f%%\n", countTo9/n*100);
        System.out.printf("From 10 to 19: %.2f%%\n", countTo19/n*100);
        System.out.printf("From 20 to 29: %.2f%%\n", countTo29/n*100);
        System.out.printf("From 30 to 39: %.2f%%\n", countTo39/n*100);
        System.out.printf("From 40 to 50: %.2f%%\n", countTo50/n*100);
        System.out.printf("Invalid numbers: %.2f%%", countInvalid/n*100);
    }
}

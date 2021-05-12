package MoreExercises.ForLoop;

import java.util.Scanner;

public class EqualPairs_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int sum1 = num1 + num2;
        int sum2 = 0;
        int diff1 = 0;
        int maxDiff = Integer.MIN_VALUE;
        int countEqual = 0;
        boolean isEqual = false;
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                num1 = Integer.parseInt(scan.nextLine());
                num2 = Integer.parseInt(scan.nextLine());

                if (i % 2 == 0) {
                    sum1 = num1 + num2;
                } else {
                    sum2 = num1 + num2;
                }
                diff1 = Math.abs(sum1 - sum2);

                if (diff1 > maxDiff) {
                    maxDiff = diff1;
                }
                if (sum1 == sum2) {
                    countEqual++;
                }
                if (countEqual == n - 1) {
                    isEqual = true;
                }
            }

        }

        if (isEqual || n==1) {
            System.out.printf("Yes, value=%d", sum1);
        } else {
            System.out.printf("No, maxdiff=%d", maxDiff);
        }
    }
}

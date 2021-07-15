package _02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class _10_SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int digit = 0;

        //sum of digits is 5, 7 or 11.

        for (int i = 1; i <= n; i++) {
            int number = i;
            sum = 0;
            while (number > 0) {
                digit = number % 10;
                sum += digit;
                number = number / 10;
            }

            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }

    }
}

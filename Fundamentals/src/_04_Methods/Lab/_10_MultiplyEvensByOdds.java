package _04_Methods.Lab;

import java.util.Scanner;

public class _10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Math.abs(Integer.parseInt(scan.nextLine()));
        int result = getOddSum(number) * getEvenSum(number);
        System.out.println(result);

    }

    private static int getOddSum(int number) {
        int oddSum = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 != 0) {
                oddSum += digit;
            }
            number /= 10;
        }
        return oddSum;
    }

    private static int getEvenSum(int number) {
        int evenSum = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            }
            number /= 10;

        }
        return evenSum;
    }
}

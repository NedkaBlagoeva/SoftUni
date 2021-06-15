package Methods_Exercise;

import java.util.Scanner;

public class _10_TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            if (isTopNumber(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isTopNumber(int num) {
        return isSumDigitsDivisibleBy8(num) && containsOneOddDigit(num);
    }

    private static boolean isSumDigitsDivisibleBy8(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }
        return sum % 8 == 0;
    }

    private static boolean containsOneOddDigit(int num) {
        int count = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit % 2 == 1) {
                count++;
            }
            num /= 10;
        }
        return count > 0;
    }
}

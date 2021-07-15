package _01_BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class _09_SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int oddNumber = 0;

        for (int i = 0; i < n; i++) {
            oddNumber = 2 * i + 1;
            System.out.println(oddNumber);
            sum += oddNumber;
        }
        System.out.println("Sum: " + sum);
    }
}

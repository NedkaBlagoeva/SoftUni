package _02_DataTypesAndVariables.Ex;

import java.util.Scanner;

public class _04_SumOfChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            char symbol = scan.nextLine().charAt(0);
            sum += symbol;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}

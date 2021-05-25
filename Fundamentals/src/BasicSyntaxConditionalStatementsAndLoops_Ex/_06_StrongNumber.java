package BasicSyntaxConditionalStatementsAndLoops_Ex;

import java.util.Scanner;

public class _06_StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input = Integer.parseInt(scan.nextLine());
        int number = input;
        int digit = 0;
        int fact = 1;
        int sum = 0;

        while (input > 0) {
            digit = input % 10;
            for (int i = 1; i <= digit; i++) {
                fact *= i;
            }
            sum += fact;
            fact = 1;
            input = input / 10;
        }
        if (sum == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}

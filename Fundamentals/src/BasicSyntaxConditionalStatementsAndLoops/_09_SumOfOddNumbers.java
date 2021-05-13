package BasicSyntaxConditionalStatementsAndLoops_Ex;

import java.util.Scanner;

public class _09_SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            temp = 2 * i + 1;
            System.out.println(temp);
            sum += temp;
        }
        System.out.println("Sum: " + sum);
    }
}

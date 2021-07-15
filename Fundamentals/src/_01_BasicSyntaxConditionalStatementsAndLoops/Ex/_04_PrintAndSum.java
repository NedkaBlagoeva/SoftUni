package _01_BasicSyntaxConditionalStatementsAndLoops.Ex;

import java.util.Scanner;

public class _04_PrintAndSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int i = n1; i <= n2; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println();
        System.out.print("Sum: " + sum);
    }
}

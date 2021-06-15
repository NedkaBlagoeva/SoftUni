package Methods_Exercise;

import java.util.Scanner;

public class _08_FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        long factorialNum1 = factorial(num1);
        long factorialNum2 = factorial(num2);
        double result = factorialNum1 * 1.0 / factorialNum2;
        System.out.printf("%.2f", result);
    }

    private static long factorial(int num) {
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}

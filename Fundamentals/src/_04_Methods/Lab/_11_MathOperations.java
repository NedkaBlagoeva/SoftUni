package _04_Methods.Lab;

import java.util.Scanner;

public class _11_MathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        char sign = scan.nextLine().charAt(0);
        int num2 = Integer.parseInt(scan.nextLine());
        double result = mathOperations(num1, sign, num2);
        System.out.printf("%.0f", result);
    }

    private static double mathOperations(int num1, char sign, int num2) {
        double result = 0;
        switch (sign) {
            case '/':
                result = num1 * 1.0 / num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '+':
                result = num1 + num2;
                break;
        }
        return result;
    }
}

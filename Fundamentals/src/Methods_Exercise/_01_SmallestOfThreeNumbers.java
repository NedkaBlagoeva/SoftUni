package Methods_Exercise;

import java.util.Scanner;

public class _01_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());

        minNumber(num1, num2, num3);
    }

    private static void minNumber(int num1, int num2, int num3) {
        System.out.println(Math.min(num1,Math.min(num2, num3)));
    }
}

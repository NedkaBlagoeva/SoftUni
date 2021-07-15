package _04_Methods.Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class _08_MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number = Double.parseDouble(scan.nextLine());
        int power = Integer.parseInt(scan.nextLine());
        System.out.println(new DecimalFormat("0.####").format(pow(number, power)));
    }

    private static double pow(double number, int power) {
        double result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }
        return result;
    }
}

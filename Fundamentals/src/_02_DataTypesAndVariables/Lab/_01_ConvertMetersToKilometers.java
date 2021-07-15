package _02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class _01_ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double m = Double.parseDouble(scan.nextLine());
        System.out.printf("%.2f", m / 1000);
    }
}

package DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _02_PoundsToDollars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double poundBritish = Double.parseDouble(scan.nextLine());

        System.out.printf("%.3f", poundBritish * 1.31);
    }
}

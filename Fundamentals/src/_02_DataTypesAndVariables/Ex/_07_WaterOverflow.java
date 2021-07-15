package _02_DataTypesAndVariables.Ex;

import java.util.Scanner;

public class _07_WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sumLitters = 0;

        for (int i = 1; i <= n; i++) {
            int littersIn = Integer.parseInt(scan.nextLine());
            if (sumLitters + littersIn > 255){
                System.out.println("Insufficient capacity!");
                continue;
            }
            sumLitters += littersIn;
        }
        System.out.println(sumLitters);
    }
}

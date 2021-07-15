package _04_Methods.Exercise;

import java.util.Scanner;

public class _07_NxNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        printNxNMatrix(num);
    }

    private static void printNxNMatrix(int num) {
        for (int row = 1; row <= num; row++) {
            printSingleLine(num);
            System.out.println();
        }
    }

    private static void printSingleLine(int num) {
        for (int i = 1; i <= num; i++) {
            System.out.print(num + " ");
        }
    }
}

package Methods_Lab;

import java.util.Scanner;

public class _03_PrintingTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height = Integer.parseInt(scan.nextLine());
        printTriangle(height);
    }

    private static void printTriangle(int height) {
        printTopHalf(height);
        printBottomHalf(height);
    }

    private static void printTopHalf(int height) {
        for (int i = 1; i < height; i++) {
            printLine(i);
            System.out.println();
        }
    }

    private static void printLine(int length) {
        for (int i = 1; i <= length; i++) {
            System.out.print(i + " ");
        }
    }

    private static void printBottomHalf(int height) {
        for (int i = height; i >= 1; i--) {
            printLine(i);
            System.out.println();
        }

    }
}

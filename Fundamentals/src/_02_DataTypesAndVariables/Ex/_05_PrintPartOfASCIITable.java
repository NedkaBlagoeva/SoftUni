package _02_DataTypesAndVariables.Ex;

import java.util.Scanner;

public class _05_PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int asciiCode = start; asciiCode <= end ; asciiCode++) {
           char symbol = (char) asciiCode;
            System.out.print(symbol + " ");
        }
    }
}

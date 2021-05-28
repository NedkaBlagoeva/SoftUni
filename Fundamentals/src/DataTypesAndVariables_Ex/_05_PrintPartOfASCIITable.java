package DataTypesAndVariables_Ex;

import java.util.Scanner;

public class _05_PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int code = start; code <= end ; code++) {
           char symbol = (char) code;
            System.out.print(symbol + " ");
        }
    }
}

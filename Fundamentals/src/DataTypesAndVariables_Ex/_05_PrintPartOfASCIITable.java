package DataTypesAndVariables_Ex;

import java.util.Scanner;

public class _05_PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int i = start; i <= end ; i++) {
           char symbol = (char) i;
            System.out.print(symbol + " ");
        }
    }
}

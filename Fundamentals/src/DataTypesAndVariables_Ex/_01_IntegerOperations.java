package DataTypesAndVariables_Ex;

import java.util.Scanner;

public class _01_IntegerOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());
        int num4 = Integer.parseInt(scan.nextLine());

        int result = (num1 + num2) / num3 * num4;
        System.out.print(result);
    }
}

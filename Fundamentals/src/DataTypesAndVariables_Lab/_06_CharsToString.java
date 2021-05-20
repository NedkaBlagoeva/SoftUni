package DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _06_CharsToString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b = scan.nextLine();
        String c = scan.nextLine();
        String string = a + b + c;
        System.out.println(string);
    }
}

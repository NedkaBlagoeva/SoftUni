package DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _07_ReversedChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char a = scan.next().charAt(0);
        char b = scan.next().charAt(0);
        char c = scan.next().charAt(0);

        String fun = String.format("%s %s %s", c, b, a);
        System.out.println(fun);
    }
}

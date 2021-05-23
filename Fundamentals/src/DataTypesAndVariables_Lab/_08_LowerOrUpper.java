package DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _08_LowerOrUpper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char letter = scan.next().charAt(0);
        int a = letter;
        if (a >= 97 && a <= 122) {
            System.out.println("lower-case");
        } else if (a >= 65 && a <= 90)
            System.out.println("upper-case");
    }
}

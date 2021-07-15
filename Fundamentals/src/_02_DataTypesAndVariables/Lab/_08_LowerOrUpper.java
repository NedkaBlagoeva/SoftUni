package _02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class _08_LowerOrUpper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char letter = scan.next().charAt(0);
        if (letter >= 97 && letter <= 122) {
            System.out.println("lower-case");
        } else if (letter >= 65 && letter <= 90)
            System.out.println("upper-case");
    }
}

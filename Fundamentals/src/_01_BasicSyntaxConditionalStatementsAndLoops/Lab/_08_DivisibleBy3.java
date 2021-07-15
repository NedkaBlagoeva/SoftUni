package _01_BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class _08_DivisibleBy3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (int i = 3; i <= 100 ; i+=3) {
            System.out.println(i);
        }
    }
}

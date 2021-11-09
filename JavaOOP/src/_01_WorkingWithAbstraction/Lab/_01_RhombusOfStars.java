package _01_WorkingWithAbstraction.Lab;

import java.util.Scanner;

public class _01_RhombusOfStars {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = 4;


        for (int r = 0; r < n; r++) {
            for (int i = r; i < n - 1; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < r; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

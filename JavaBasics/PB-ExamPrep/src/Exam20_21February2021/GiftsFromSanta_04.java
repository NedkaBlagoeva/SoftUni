package Exam20_21February2021;

import java.util.Scanner;

public class GiftsFromSanta_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        int s = Integer.parseInt(scan.nextLine());

        for (int i = m; i >= n; i--) {

            if (i % 2 == 0 && i % 3 == 0) {
                if (i == s) {
                    break;
                }
                System.out.print(i + " ");
            }
        }
    }
}

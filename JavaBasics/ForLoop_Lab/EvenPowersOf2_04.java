package ForLoop_Lab;

import java.util.Scanner;

public class EvenPowersOf2_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                double a = Math.pow(2, i);
                System.out.printf("%.0f%n", a);

            }
        }
    }
}


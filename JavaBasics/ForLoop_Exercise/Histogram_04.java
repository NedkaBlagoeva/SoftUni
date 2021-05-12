package ForLoop_Exercise;

import java.util.Scanner;

public class Histogram_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int p1count = 0;
        int p2count = 0;
        int p3count = 0;
        int p4count = 0;
        int p5count = 0;
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(scan.nextLine());

            if (num < 200) {
                p1count++;
            } else if (num <= 399) {
                p2count++;
            } else if (num <= 599) {
                p3count++;
            } else if (num <= 799) {
                p4count++;
            } else {
                p5count++;
            }
        }
        System.out.printf("%.2f%%\n", p1count * 1.0 / n * 100);
        System.out.printf("%.2f%%\n", p2count * 1.0 / n * 100);
        System.out.printf("%.2f%%\n", p3count * 1.0 / n * 100);
        System.out.printf("%.2f%%\n", p4count * 1.0 / n * 100);
        System.out.printf("%.2f%%\n", p5count * 1.0 / n * 100);
    }
}

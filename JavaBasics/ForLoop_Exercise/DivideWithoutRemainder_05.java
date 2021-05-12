package ForLoop_Exercise;

import java.util.Scanner;

public class DivideWithoutRemainder_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double p1count = 0.0;
        double p2count = 0.0;
        double p3count = 0.0;
        for (int i = 0; i < n; i++) {
            double num = Double.parseDouble(scan.nextLine());
            if (num % 2 == 0) {
                p1count++;
            }if (num % 3 == 0){
                p2count++;
            }if (num % 4 == 0){
                p3count++;
            }

        }
        System.out.printf("%.2f%%\n", p1count / n * 100);
        System.out.printf("%.2f%%\n", p2count / n * 100);
        System.out.printf("%.2f%%", p3count / n * 100);

    }
}

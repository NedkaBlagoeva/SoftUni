package ForLoop_Lab;

import java.util.Scanner;

public class LeftAndRightSum_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= n * 2; i++) {
            int num = Integer.parseInt(scan.nextLine());
            if (i <= n) {
                sum1 += num;
            } else {
                sum2 += num;
            }
        }
        int diff = Math.abs(sum1 - sum2);
        if (sum1 == sum2) {
            System.out.printf("Yes, sum = %d", sum1);
        }else {
            System.out.printf("No, diff = %d", diff);
        }

    }
}

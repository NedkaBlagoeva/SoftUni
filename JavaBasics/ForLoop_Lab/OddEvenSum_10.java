package ForLoop_Lab;

import java.util.Scanner;

public class OddEvenSum_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(scan.nextLine());
            if (i%2 == 0) {
                evenSum += num;
            } else {
                oddSum += num;
            }
        }
        int diff = Math.abs(oddSum - evenSum);
        if (oddSum == evenSum) {
            System.out.printf("Yes%n Sum = %d", evenSum);
        }else {
            System.out.printf("No%n Diff = %d", diff);
        }

    }
}

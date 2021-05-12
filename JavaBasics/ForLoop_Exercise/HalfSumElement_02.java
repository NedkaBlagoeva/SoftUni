package ForLoop_Exercise;

import java.util.Scanner;

public class HalfSumElement_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int maxNumber = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scan.nextLine());
            sum += num;
            if (num > maxNumber) {
                maxNumber = num;
            }
        } if (sum-maxNumber == maxNumber){
            System.out.printf("Yes\nSum = %d", sum-maxNumber);
        }else{
            System.out.printf("No\nDiff = %d", Math.abs(sum-2*maxNumber));
        }
    }
}

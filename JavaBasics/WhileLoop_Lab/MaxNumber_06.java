package WhileLoop_Lab;

import java.util.Scanner;

public class MaxNumber_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();
        int maxNum = Integer.MIN_VALUE;

        while (!num.equals("Stop")) {
            int currentNum = Integer.parseInt(num);
            if (currentNum > maxNum) {
                maxNum = currentNum;
            }
            num = scan.nextLine();
        }
        System.out.println(maxNum);
    }
}

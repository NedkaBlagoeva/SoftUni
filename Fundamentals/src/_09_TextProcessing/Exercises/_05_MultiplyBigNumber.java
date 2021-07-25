package _09_TextProcessing.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _05_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] bigNumber = Arrays.stream(scan.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int num = Integer.parseInt(scan.nextLine());
        StringBuilder result = new StringBuilder();
        int remainder = 0;
        int tens = 0;
        if (bigNumber.length == 0){
            System.out.println("0");
            return;
        }
        for (int i = bigNumber.length - 1; i >= 0; i--) {
            int num1 = bigNumber[i];
            int midResult = num1 * num;
            remainder = midResult % 10;
            result.append(remainder + tens);
            if (midResult > 9) {
                tens = midResult / 10;
            } else {
                tens = 0;
            }
        }
        if (tens != 0){
            result.append(tens);
        }

        System.out.println(result.reverse());
    }
}

package _09_TextProcessing.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _05_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] bigNumber = Arrays.stream(scan.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int num = Integer.parseInt(scan.nextLine());
        StringBuilder result = new StringBuilder();
        int remainder = 0;
        int tens = 0;
        for (int i = bigNumber.length - 1; i >= 0; i--) {
            int num1 = Integer.parseInt(String.valueOf(bigNumber[i]));
            int midResult = num1 * num;
            if (midResult > 9){
                result.append(midResult % 10);
            }
        }
    }
}

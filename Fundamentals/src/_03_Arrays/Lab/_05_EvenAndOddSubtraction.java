package _03_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _05_EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int evenSum = 0;
        int oddSum = 0;
        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int item : input) {
            if (item % 2 == 0) {
                evenSum += item;
            } else {
                oddSum += item;
            }
        }
        System.out.println(evenSum - oddSum);
    }
}

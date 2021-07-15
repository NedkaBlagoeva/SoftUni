package _03_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _07_CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        while (input.length > 1) {
            int[] condensed = new int[input.length - 1];
            for (int i = 0; i < input.length - 1; i++) {
                condensed[i] = input[i] + input[i + 1];
            }
            input = condensed;
        }
        System.out.println(input[0]);
    }
}


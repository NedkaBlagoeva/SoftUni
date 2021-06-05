package Array_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int count = 1;
        int countMax = 0;
        int element = 0;
        for (int i = 0; i < input.length-1; i++) {
            if (input[i] == input[i + 1]) {
                count++;
                if (count > countMax) {
                    countMax = count;
                    element = input[i];
                }
            } else {
                count = 1;
            }
        }
        for (int i = 1; i <= countMax; i++) {
            System.out.print(element + " ");
        }
    }
}

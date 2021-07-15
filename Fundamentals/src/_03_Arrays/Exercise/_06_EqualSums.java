package _03_Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _06_EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        boolean areEqual = false;
        for (int currentElement = 0; currentElement < input.length; currentElement++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = currentElement + 1; j < input.length; j++) {
                rightSum += input[j];
            }
            for (int j = 0; j < currentElement; j++) {
                leftSum += input[j];
            }
            if (rightSum == leftSum) {
                System.out.println(currentElement);
                areEqual = true;
                break;
            }
        }
        if (!areEqual) {
            System.out.println("no");
        }
    }
}

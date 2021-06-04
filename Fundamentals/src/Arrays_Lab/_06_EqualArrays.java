package Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _06_EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] firstArray = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        String[] input2 = scan.nextLine().split(" ");
        int[] secondArray = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            secondArray[i] = Integer.parseInt(input2[i]);
        }
        boolean areEqual = true;
        int sum = 0;
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != secondArray[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                areEqual = false;
                break;
            } else {
                sum += firstArray[i];
            }
        }
        if (areEqual) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}


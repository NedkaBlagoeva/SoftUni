package Array_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _05_TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length; i++) {
            boolean isTopNumber = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] <= numbers[j]) {
                    isTopNumber = false;
                }
            }
            if (isTopNumber) {
                System.out.print(numbers[i] + " ");
            }
        }
    }
}

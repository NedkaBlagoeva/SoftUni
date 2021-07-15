package _03_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _03_SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int sum = 0;
        for (int i : numbers) {
            if (i % 2 == 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}

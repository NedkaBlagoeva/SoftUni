package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _02_SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputNumbers = scan.nextLine();
        Function<String, Integer> count = str -> str
                .split(", ")
                .length;
        Function<String, Integer> sum = str -> Arrays.
                stream(str.split(", "))
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.printf("Count = %d%nSum = %d", count.apply(inputNumbers), sum.apply(inputNumbers));
    }
}

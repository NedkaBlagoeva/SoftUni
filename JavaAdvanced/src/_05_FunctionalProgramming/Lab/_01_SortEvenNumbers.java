package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class _01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> input = Arrays
                .stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> evenNumbers = input.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        String toPrintEven = evenNumbers
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(toPrintEven);

        String sorted = evenNumbers
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(sorted);
    }
}

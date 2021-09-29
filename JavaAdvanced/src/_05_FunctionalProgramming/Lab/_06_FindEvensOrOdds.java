package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _06_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] bounds = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String condition = scan.nextLine();
        Predicate<Integer> evenOrOdd =
                condition.equals("even")
                        ? n -> n % 2 == 0
                        : n -> n % 2 != 0;

        printNumbers(bounds[0], bounds[1], evenOrOdd);

    }

    public static void printNumbers(int startInclusive, int endInclusive, Predicate<Integer> predicate) {
        System.out.println(IntStream.rangeClosed(startInclusive, endInclusive)
                .boxed()
                .filter(predicate)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}

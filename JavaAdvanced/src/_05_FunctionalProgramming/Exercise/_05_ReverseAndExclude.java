package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scan.nextLine());
        Predicate<Integer> divisible = i -> i % n != 0;
        Collections.reverse(numbers);
        String output = numbers.stream().filter(divisible).map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(output);

    }
}

package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        List<String> names = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> filter = str -> str.length() <= length;
        
        names.stream()
                .filter(filter)
                .forEach(System.out::println);
    }
}

package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] splitInput = scan.nextLine().split("\\s+");
        Predicate<String> startWithUppercase = str -> Character.isUpperCase(str.charAt(0));
        List<String> strUppercase = Arrays
                .stream(splitInput)
                .filter(startWithUppercase)
                .collect(Collectors.toList());
       
        System.out.println(strUppercase.size());
        strUppercase.forEach(System.out::println);
    }
}

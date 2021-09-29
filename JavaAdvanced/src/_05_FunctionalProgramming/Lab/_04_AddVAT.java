package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class _04_AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> input = Arrays
                .stream(scan.nextLine().split(", "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        UnaryOperator<Double> vatCalculator = price -> price * 1.2;
        System.out.println("Prices with VAT:");
        input.stream().map(vatCalculator).forEach(e -> System.out.printf("%.2f%n", e));
    }
}

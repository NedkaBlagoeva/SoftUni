package _08_MapsLambdaAndStreamAPI.Lab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder()).limit(3)
                .collect(Collectors.toList());
        numbers.forEach(e -> System.out.print(e + " "));
    }
}

package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Arrays.stream(scan.nextLine().split("\\s+")).forEach(System.out::println);
    }
}

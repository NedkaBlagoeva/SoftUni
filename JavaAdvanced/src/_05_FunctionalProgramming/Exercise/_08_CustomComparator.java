package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;

import java.util.Scanner;

public class _08_CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


    }
}

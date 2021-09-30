package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputNumbers = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String command = scan.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    inputNumbers = Arrays.stream(inputNumbers).map(i -> i + 1).toArray();
                    break;
                case "multiply":
                    inputNumbers = Arrays.stream(inputNumbers).map(i -> i * 2).toArray();
                    break;
                case "subtract":
                    inputNumbers = Arrays.stream(inputNumbers).map(i -> i - 1).toArray();
                    break;
                case "print":
                    String output = Arrays
                            .stream(inputNumbers)
                            .boxed()
                            .map(String::valueOf)
                            .collect(Collectors.joining(" "));
                    System.out.println(output);
                    break;
                default:
                    break;
            }
            command = scan.nextLine();
        }
    }
}

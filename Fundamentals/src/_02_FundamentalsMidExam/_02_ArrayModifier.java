package _02_FundamentalsMidExam;

import java.util.Arrays;
import java.util.Scanner;

public class _02_ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String command = scan.nextLine();
        while (!"end".equals(command)) {
            String[] tokens = command.split(" ");
            String operation = tokens[0];
            int index1 = 0;
            int index2 = 0;
            if (tokens.length > 1) {
                index1 = Integer.parseInt(tokens[1]);
                index2 = Integer.parseInt(tokens[2]);
            }
            switch (operation) { //swap {index1} {index2}”; “multiply {index1} {index2}”; “decrease”;
                case "swap":
                    swap(index1, index2, numbers);
                    break;
                case "multiply":
                    multiply(index1, index2, numbers);
                    break;
                case "decrease":
                    decrease(numbers);
                    break;
                default:
                    break;
            }
            command = scan.nextLine();
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.print(numbers[numbers.length - 1]);
    }

    private static void swap(int index1, int index2, int[] numbers) {
        int temp = 0;
        temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

    private static void multiply(int index1, int index2, int[] numbers) {
        numbers[index1] = numbers[index1] * numbers[index2];
    }

    private static void decrease(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] -= 1;
        }
    }
}


package Lists_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        Contains {number} – check if the list contains the number. If yes print "Yes", otherwise print "No such number"
//        Print even – print all the numbers that are even separated by a space
//        Print odd – print all the numbers that are odd separated by a space
//        Get sum – print the sum of all the numbers
//        Filter ({condition} {number}) – print all the numbers that fulfill that condition.
//        The condition will be either '<', '>', ">=", "<="
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            String commandWord = command[0];
            switch (commandWord) {
                case "Contains":
                    int searchedNumber = Integer.parseInt(command[1]);
                    contain(numbers, searchedNumber);
                    break;
                case "Print":
                    String secondCommandWord = command[1];
                    printEvenOrOdd(numbers, secondCommandWord);
                    break;
                case "Get":
                    getSum(numbers);
                    break;
                case "Filter":
                    String operator = command[1];
                    int number = Integer.parseInt(command[2]);
                    filter(numbers, operator, number);
                    break;
            }
            input = scan.nextLine();
        }
    }

    private static void contain(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }

    private static void printEvenOrOdd(List<Integer> numbers, String command) {
        switch (command) {
            case "even":
                for (Integer number : numbers) {
                    if (number % 2 == 0) {
                        System.out.print(number + " ");
                    }
                }
                System.out.println();
                break;
            case "odd":
                for (Integer number : numbers) {
                    if (number % 2 != 0) {
                        System.out.print(number + " ");
                    }
                }
                System.out.println();
                break;
            default:
                break;
        }
    }

    private static void getSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer integer : numbers) {
            sum += integer;
        }
        System.out.println(sum);
    }

    private static void filter(List<Integer> numbers, String operator, int number) {
        switch (operator) {
            case ">":
                for (Integer integer : numbers) {
                    if (integer > number) {
                        System.out.print(integer + " ");
                    }
                }
                System.out.println();
                break;
            case ">=":
                for (Integer integer : numbers) {
                    if (integer >= number) {
                        System.out.print(integer + " ");
                    }
                }
                System.out.println();
                break;
            case "<":
                for (Integer integer : numbers) {
                    if (integer < number) {
                        System.out.print(integer + " ");
                    }
                }
                System.out.println();
                break;
            case "<=":
                for (Integer integer : numbers) {
                    if (integer <= number) {
                        System.out.print(integer + " ");
                    }
                }
                System.out.println();
                break;
        }
    }
}

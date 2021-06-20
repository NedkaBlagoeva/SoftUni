package List_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split("\\s+");
            String commandWord = commands[0];
            switch (commandWord) {
                case "Add":
                    int numberToAdd = Integer.parseInt(commands[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(commands[1]);
                    int indexInsert = Integer.parseInt(commands[2]);
                    if (isValidIndex(numbers, indexInsert)) {
                        numbers.add(indexInsert, numberToInsert);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(commands[1]);
                    if (isValidIndex(numbers, indexToRemove)) {
                        numbers.remove(indexToRemove);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String direction = commands[1];
                    int count = Integer.parseInt(commands[2]);
                    if (direction.equals("left")) {
                        shiftLeft(numbers, count);
                    } else if (direction.equals("right")) {
                        shiftRight(numbers, count);
                    }
                    break;
                default:
                    break;
            }

            input = scan.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static void shiftRight(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
    }

    private static void shiftLeft(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(list.size(), list.get(0));
            list.remove(0);
        }
    }

    private static boolean isValidIndex(List<Integer> list, int index) {
        return index >= 0 && index < list.size();
    }
}
//        •	Add {number} - add number at the end
//        •	Insert {number} {index} - insert number at given index
//        •	Remove {index} - remove that index
//        •	Shift left {count} - first number becomes last 'count' times
//        •	Shift right {count} - last number becomes first 'count' times

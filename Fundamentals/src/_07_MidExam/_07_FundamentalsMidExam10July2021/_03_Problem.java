package _07_MidExam._07_FundamentalsMidExam10July2021;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_Problem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> groceries = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!"Shop!".equals(input)) {
            String[] commands = input.split("%");
            String command = commands[0];
            String product = commands[1];
            switch (command) {
                case "Important":
                    important(groceries, product);
                    break;
                case "Add":
                    add(groceries, product);
                    break;
                case "Remove":
                    remove(groceries, product);
                    break;
                case "Swap":
                    String item2 = commands[2];
                    swap(groceries, product, item2);
                    break;
                case "Reversed:":
                    Collections.reverse(groceries);
                    break;
                default:
                    break;
            }
            input = scan.nextLine();
        }
        print(groceries);
    }

    public static void important(List<String> groceries, String item) {
        groceries.remove(item);
        groceries.add(0, item);
    }

    public static void add(List<String> groceries, String item) {
        if (!groceries.contains(item)) {
            groceries.add(item);
        } else {
            System.out.println("The product is already in the list.");
        }
    }

    public static void swap(List<String> groceries, String item1, String item2) {
        int index1 = -1;
        int index2 = -1;
        if (groceries.contains(item1) && groceries.contains(item2)) {
            for (int i = 0; i < groceries.size(); i++) {
                if (groceries.get(i).equals(item1)) {
                    index1 = i;
                }
                if (groceries.get(i).equals(item2)) {
                    index2 = i;
                }
            }
            groceries.set(index1, item2);
            groceries.set(index2, item1);
        } else {
            if (groceries.contains(item1)) {
                System.out.printf("Product %s missing!%n", item2);
            } else {
                System.out.printf("Product %s missing!%n", item1);
            }
        }
    }

    public static void remove(List<String> groceries, String item) {
        if (groceries.contains(item)) {
            groceries.remove(item);
        } else {
            System.out.printf("Product %s isn't in the list.%n", item);
        }
    }

    private static void print(List<String> groceries) {
        for (int i = 0; i <= groceries.size() - 1; i++) {
            System.out.printf("%d. %s%n", i + 1, groceries.get(i));
        }
    }
}

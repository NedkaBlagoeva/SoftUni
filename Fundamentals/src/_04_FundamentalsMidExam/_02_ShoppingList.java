package _04_FundamentalsMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> groceries = Arrays.stream(scan.nextLine().split("!")).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!"Go Shopping!".equals(input)) {
            String[] commands = input.split("\\s+");
            String command = commands[0];
            String item = commands[1];
            switch (command) {
                case "Urgent":
                    urgent(groceries, item);
                    break;
                case "Unnecessary":
                    unnecessary(groceries, item);
                    break;
                case "Correct":
                    String newItem = commands[2];
                    correct(groceries, item, newItem);
                    break;
                case "Rearrange":
                    rearrange(groceries, item);
                    break;
                default:
                    break;
            }
            input = scan.nextLine();
        }
        print(groceries);
    }


    public static void urgent(List<String> groceries, String item) {
        if (!groceries.contains(item)) {
            groceries.add(0, item);
        }
    }

    public static void unnecessary(List<String> groceries, String item) {
        groceries.remove(item);
    }

    public static void correct(List<String> groceries, String oldItem, String newItem) {
        if (groceries.contains(oldItem)) {
            for (int i = 0; i < groceries.size(); i++) {
                if (groceries.get(i).equals(oldItem)) {
                    groceries.set(i, newItem);
                }
            }
        }
    }

    private static void rearrange(List<String> groceries, String item) {
        if (groceries.contains(item)) {
            groceries.remove(item);
            groceries.add(item);
        }
    }

    private static void print(List<String> groceries) {
        for (int i = 0; i < groceries.size() - 1; i++) {
            System.out.print(groceries.get(i) + ", ");
        }
        System.out.print(groceries.get(groceries.size() - 1));
    }
}

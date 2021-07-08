package _05_FundamentalsMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> items = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!"Craft!".equals(input)) {
            String[] commands = input.split(" - ");
            String command = commands[0];
            String item = commands[1];
            switch (command) {
                case "Collect":
                    collect(items, item);
                    break;
                case "Drop":
                    drop(items, item);
                    break;
                case "Combine Items":
                    String oldItem = commands[1].split(":")[0];
                    String newItem = commands[1].split(":")[1];
                    combine(items, oldItem, newItem);
                    break;
                case "Renew":
                    renew(items, item);
                    break;
                default:
                    break;
            }
            input = scan.nextLine();
        }
        print(items);
    }


    public static void collect(List<String> items, String item) {
        if (!items.contains(item)) {
            items.add(item);
        }
    }

    public static void drop(List<String> items, String item) {
        items.remove(item);
    }

    public static void combine(List<String> items, String oldItem, String newItem) {
        if (items.contains(oldItem)) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).equals(oldItem)) {
                    items.add(i + 1, newItem);
                }
            }
        }
    }

    private static void renew(List<String> items, String item) {
        if (items.contains(item)) {
            items.remove(item);
            items.add(item);
        }
    }

    private static void print(List<String> items) {
        for (int i = 0; i < items.size() - 1; i++) {
            System.out.print(items.get(i) + ", ");
        }
        System.out.print(items.get(items.size() - 1));
    }
}

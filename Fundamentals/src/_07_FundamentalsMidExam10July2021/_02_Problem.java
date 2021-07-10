package _07_FundamentalsMidExam10July2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_Problem {
    private static int countBlacklisted;
    private static int countLost;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> usernames = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String input = scan.nextLine();

        while (!input.equals("Report")) {
            String[] commands = input.split("\\s+");
            String command = commands[0];
            switch (command) {
                case "Blacklist":
                    String name = commands[1];
                    blacklist(usernames, name);
                    break;
                case "Error":
                    int index = Integer.parseInt(commands[1]);
                    error(usernames, index);
                    break;
                case "Change":
                    int index1 = Integer.parseInt(commands[1]);
                    String newName = commands[2];
                    change(usernames, index1, newName);
                    break;
                default:
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n", countBlacklisted);
        System.out.printf("Lost names: %d%n", countLost);
        print(usernames);
    }

    private static boolean isValidIndex(List<String> usernames, int index) {
        return index >= 0 && index < usernames.size();
    }

    private static void blacklist(List<String> usernames, String name) {
        if (usernames.contains(name)) {
            for (int i = 0; i < usernames.size(); i++) {
                if (usernames.get(i).equals(name)) {
                    System.out.printf("%s was blacklisted.%n", name);
                    usernames.set(i, "Blacklisted");
                    countBlacklisted++;
                }
            }
        } else {
            System.out.printf("%s was not found.%n", name);
        }
    }

    private static void error(List<String> usernames, int index) {
        if (isValidIndex(usernames, index) &&
                !usernames.get(index).equals("Blacklisted") &&
                !usernames.get(index).equals("Lost")) {
            System.out.printf("%s was lost due to an error.%n", usernames.get(index));
            usernames.set(index, "Lost");
            countLost++;
        }
    }

    private static void change(List<String> usernames, int index, String newName) {
        if (isValidIndex(usernames, index)) {
            System.out.printf("%s changed his username to %s.%n", usernames.get(index), newName);
            usernames.set(index, newName);
        }
    }

    private static void print(List<String> usernames) {
        for (int i = 0; i < usernames.size(); i++) {
            System.out.print(usernames.get(i) + " ");
        }
    }
}

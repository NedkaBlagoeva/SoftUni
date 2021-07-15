package _07_MidExam._03_FundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] commands = input.split("\\s+");
            String command = commands[0];
            int index = Integer.parseInt(commands[1]);
            int command3 = Integer.parseInt(commands[2]);
            switch (command) {
                case "Shoot":
                    shoot(targets, index, command3);
                    break;
                case "Add":
                    add(targets, index, command3);
                    break;
                case "Strike":
                    strike(targets, index, command3);
                    break;
                default:
                    break;
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < targets.size() - 1; i++) {
            System.out.print(targets.get(i) + "|");
        }
        System.out.print(targets.get(targets.size() - 1));
    }

    public static void shoot(List<Integer> targets, int index, int power) {
        if (isValidIndex(targets, index)) {
            targets.set(index, targets.get(index) - power);
            if (targets.get(index) <= 0) {
                targets.remove(index);
            }
        }
    }

    public static void add(List<Integer> targets, int index, int value) {
        if (isValidIndex(targets, index)) {
            targets.add(index, value);
        } else {
            System.out.println("Invalid placement!");
        }
    }

    public static void strike(List<Integer> targets, int index, int radius) {
        if (isValidIndex(targets, index - radius) && isValidIndex(targets, index + radius)) {
            for (int i = 0; i < radius * 2 + 1; i++) {
                targets.remove(index - radius);
            }
        } else {
            System.out.println("Strike missed!");
        }
    }

    public static boolean isValidIndex(List<Integer> numbers, int index) {
        return index >= 0 && index < numbers.size();
    }
}

package _07_MidExam._01_FundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> sequence = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        int count = 0;
        String input = scan.nextLine();
        while (!"end".equals(input)) {
            if (sequence.isEmpty()) {
                break;
            }
            count++;
            int index1 = Integer.parseInt(input.split("\\s+")[0]);
            int index2 = Integer.parseInt(input.split("\\s+")[1]);
            if (isCheating(sequence, index1, index2)) {
                System.out.println("Invalid input! Adding additional elements to the board");
                sequence.add(sequence.size() / 2, "-" + count + "a");
                sequence.add(sequence.size() / 2, "-" + count + "a");
                input = scan.nextLine();
                continue;
            }
            if (sequence.get(index1).equals(sequence.get(index2))) {
                System.out.printf("Congrats! You have found matching elements - %s!%n", sequence.get(index1));
                if (index1 > index2) {
                    sequence.remove(index1);
                    sequence.remove(index2);
                } else {
                    sequence.remove(index2);
                    sequence.remove(index1);
                }
            } else {
                System.out.println("Try again!");
            }
            input = scan.nextLine();
        }
        if (sequence.isEmpty()) {
            System.out.printf("You have won in %d turns!", count);
        } else {
            System.out.println("Sorry you lose :(");
            for (String s : sequence) {
                System.out.print(s + " ");
            }
        }
    }

    private static boolean isCheating(List<String> sequence, int index1, int index2) {
        if (index1 == index2) {
            return true;
        }
        if (index1 < 0 || index1 >= sequence.size()) {
            return true;
        }
        if (index2 < 0 || index2 >= sequence.size()) {
            return true;
        }
        return false;
    }
}

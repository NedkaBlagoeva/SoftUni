package _01_FundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> inputSequence = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        int count = 0;
        String input = scan.nextLine();
        while (!"end".equals(input)) {
            if(inputSequence.isEmpty()){
                break;
            }
            count++;
            int index1 = Integer.parseInt(input.split("\\s+")[0]);
            int index2 = Integer.parseInt(input.split("\\s+")[1]);
            if (!isValidIndex(inputSequence.size(), index1) ||
                    !isValidIndex(inputSequence.size(), index2) ||
                    index1 == index2) {
                System.out.println("Invalid input! Adding additional elements to the board");
                inputSequence.add(inputSequence.size() / 2, "-" + count + "a");
                inputSequence.add(inputSequence.size() / 2, "-" + count + "a");
                input = scan.nextLine();
                continue;
            }
            if (inputSequence.get(index1).equals(inputSequence.get(index2))) {
                System.out.printf("Congrats! You have found matching elements - %s!%n", inputSequence.get(index1));
                if (index1 > index2) {
                    inputSequence.remove(index1);
                    inputSequence.remove(index2);
                } else {
                    inputSequence.remove(index2);
                    inputSequence.remove(index1);
                }
            } else {
                System.out.println("Try again!");
            }
            input = scan.nextLine();
        }
        if (inputSequence.isEmpty()) {
            System.out.printf("You have won in %d turns!", count);
        } else {
            System.out.println("Sorry you lose :(");
            for (String s : inputSequence) {
                System.out.print(s + " ");
            }
        }
    }

    public static boolean isValidIndex(int length, int index) {
        return index >= 0 && index < length;
    }
}

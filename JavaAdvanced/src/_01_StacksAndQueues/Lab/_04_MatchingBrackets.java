package _01_StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> bracketsIndexes = new ArrayDeque<>();
        String input = scan.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                bracketsIndexes.push(i);
            } else if (input.charAt(i) == ')') {
                System.out.println(input.substring(bracketsIndexes.pop(), i + 1));
            }
        }
    }
}

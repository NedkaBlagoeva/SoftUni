package _01_StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> elements = new ArrayDeque<>();
        String[] input = scan.nextLine().split("\\s+");
        for (int i = input.length - 1; i >= 0; i--) {
            elements.push(input[i]);
        }
        int result = Integer.parseInt(elements.pop());
        int i = 1;
        while (!elements.isEmpty()) {
            if (elements.peek().equals("+")) {
                elements.pop();
                result += Integer.parseInt(elements.pop());
            } else {
                elements.pop();
                result -= Integer.parseInt(elements.pop());
            }
            i++;
        }
        System.out.println(result);
    }
}

package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> result = new ArrayDeque<>();
        int input = Integer.parseInt(scan.nextLine());
        if (input == 0) {
            System.out.println(0);
            return;
        }
        while (input > 0) {
            result.push(input % 2);
            input /= 2;
        }
        while (!result.isEmpty()) {
            System.out.print(result.pop());
        }
    }
}

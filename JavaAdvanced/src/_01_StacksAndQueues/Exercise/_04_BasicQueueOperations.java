package _01_StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int s = input[1];
        int x = input[2];
        int[] numbersToAdd = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            numbers.offer(numbersToAdd[i]);
        }
        for (int i = 0; i < s; i++) {
            numbers.poll();
        }
        if (numbers.contains(x)) {
            System.out.println(true);
        } else if (numbers.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(numbers));
        }
    }
}

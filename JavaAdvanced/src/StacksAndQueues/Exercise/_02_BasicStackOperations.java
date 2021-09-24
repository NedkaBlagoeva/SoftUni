package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputNumbers = scan.nextLine().split(" ");
        String[] inputNumbersToPush = scan.nextLine().split(" ");
        int nToPush = Integer.parseInt(inputNumbers[0]);
        int sToPop = Integer.parseInt(inputNumbers[1]);
        int xToFind = Integer.parseInt(inputNumbers[2]);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < nToPush; i++) {
            numbers.push(Integer.parseInt(inputNumbersToPush[i]));
        }
        for (int i = 0; i < sToPop; i++) {
            numbers.pop();
        }
        if (numbers.contains(xToFind)) {
            System.out.println("true");
        } else if (numbers.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(numbers));
        }
    }
}


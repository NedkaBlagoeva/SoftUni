package ExamPrep.RetakeExam_14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> tulipStack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(tulipStack::push);
        ArrayDeque<Integer> daffodilsQueue = Arrays
                .stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int bouquets = 0;
        int sumLeftover = 0;

        while (!tulipStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int sumPeek = tulipStack.peek() + daffodilsQueue.peek();
            if (sumPeek == 15) {
                bouquets++;
                tulipStack.pop();
                daffodilsQueue.poll();
            } else if (sumPeek > 15) {
                int temp = tulipStack.pop();
                tulipStack.push(temp - 2);
            } else {
                sumLeftover += sumPeek;
                tulipStack.pop();
                daffodilsQueue.poll();
            }
        }

        bouquets += sumLeftover / 15;

        if (bouquets >= 5) {
            System.out.println("You made it! You go to the competition with " + bouquets + " bouquets!");
        } else {
            System.out.println("You failed... You need more " + (5 - bouquets) + " bouquets.");
        }
    }
}

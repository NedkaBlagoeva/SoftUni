package ExamPrep.Exam_20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> boxDeque = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> boxStack = new ArrayDeque<>();
        Arrays
                .stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(boxStack::push);

        int claimedItems = 0;
        while (!boxDeque.isEmpty() && !boxStack.isEmpty()) {
            int firstItem = boxDeque.peek();
            int lastItem = boxStack.pop();
            int sum = firstItem + lastItem;

            if (sum % 2 == 0) {
                claimedItems += sum;
                boxDeque.poll();
            } else {
                boxDeque.offer(lastItem);
            }
        }
        if (boxDeque.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (boxStack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (claimedItems >= 90){
            System.out.println("Wow, your prey was epic! Value: " + claimedItems);
        } else {
            System.out.println("Poor prey... Value: " + claimedItems);
        }
    }
}

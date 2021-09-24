package _01_StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _06_HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).forEach(queue::offer);
        int number = Integer.parseInt(scan.nextLine());

        while (queue.size() > 1) {
            for (int i = 0; i < number - 1; i++) {
                String childToAdd = queue.poll();
                queue.offer(childToAdd);
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}

package _01_StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<String> printQueue = new ArrayDeque<>();
        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (printQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                    input = scan.nextLine();
                    continue;
                } else {
                    System.out.println("Canceled " + printQueue.poll());
                }
            } else {
                printQueue.offer(input);
            }
            input = scan.nextLine();
        }
        while (!printQueue.isEmpty()) {
            System.out.println(printQueue.poll());
        }
    }
}

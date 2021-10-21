package ExamPrep.Exam_26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_OS_Planing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays
                .stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int taskToBeKilled = Integer.parseInt(scan.nextLine());

        while (!(tasks.isEmpty() || threads.isEmpty())) {
            if (tasks.peek() == taskToBeKilled) {
                System.out.printf("Thread with value %d killed task %d%n", threads.peek(), tasks.peek());
                break;
            }

            if (threads.peek() >= tasks.peek()) {
                tasks.pop();
            }
            threads.poll();
        }
        threads.forEach(t -> System.out.print(t + " "));
    }
}

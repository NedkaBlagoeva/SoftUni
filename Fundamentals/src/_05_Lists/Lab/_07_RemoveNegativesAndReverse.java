package _05_Lists.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _07_RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        removeNegative(numbers);
        Collections.reverse(numbers);
        if (numbers.isEmpty()) {
            System.out.println("empty");
        } else {
            for (Integer number : numbers) {
                System.out.print(number + " ");
            }
        }
    }

    private static void removeNegative(List<Integer> numbers) {
        numbers.removeIf(number -> number < 0);
    }
}

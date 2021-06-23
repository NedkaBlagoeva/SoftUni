package List_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _06_CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstPlayerCards = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerCards = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        while (!firstPlayerCards.isEmpty() && !secondPlayerCards.isEmpty()) {
            if (firstPlayerCards.get(0) > secondPlayerCards.get(0)) {
                firstPlayerCards.add(secondPlayerCards.get(0));
                firstPlayerCards.add(firstPlayerCards.get(0));
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            } else if (secondPlayerCards.get(0) > firstPlayerCards.get(0)) {
                secondPlayerCards.add(firstPlayerCards.get(0));
                secondPlayerCards.add(secondPlayerCards.get(0));
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            } else {
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            }

            int sum = 0;
            if (firstPlayerCards.isEmpty()) {
                for (Integer Card : secondPlayerCards) {
                    sum += Card;
                }
                System.out.printf("Second player wins! Sum: %d", sum);
            } else if (secondPlayerCards.isEmpty()) {
                for (Integer Card : firstPlayerCards) {
                    sum += Card;
                }
                System.out.printf("First player wins! Sum: %d", sum);
            }
        }
    }
}

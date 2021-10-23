package ExamPrep.Mine_23Oct2021;

import java.util.*;
import java.util.stream.Collectors;

public class _01_AutumnCocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> ingredientsDeque = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(freshnessStack::push);

        int freshness = 0;
        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        while (!(ingredientsDeque.isEmpty() || freshnessStack.isEmpty())) {
            if (ingredientsDeque.peek() == 0) {
                ingredientsDeque.poll();
                continue;
            }
            freshness = ingredientsDeque.peek() * freshnessStack.peek();
            switch (freshness) {
                case 150:
                    freshnessStack.pop();
                    ingredientsDeque.poll();
                    cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                    break;
                case 250:
                    freshnessStack.pop();
                    ingredientsDeque.poll();
                    cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                    break;
                case 300:
                    freshnessStack.pop();
                    ingredientsDeque.poll();
                    cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                    break;
                case 400:
                    freshnessStack.pop();
                    ingredientsDeque.poll();
                    cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                    break;
                default:
                    int fistIng = ingredientsDeque.poll();
                    ingredientsDeque.offer(fistIng + 5);
                    freshnessStack.pop();
                    break;
            }
        }

        boolean allCocktailsDone = true;
        for (Integer value : cocktails.values()) {
            if (value == 0) {
                allCocktailsDone = false;
                break;
            }
        }

        if (allCocktailsDone) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int sum = 0;
        if (!ingredientsDeque.isEmpty()) {
            for (Integer integer : ingredientsDeque) {
                sum += integer;
            }
            System.out.println("Ingredients left: " + sum);
        }

        cocktails
                .entrySet()
                .stream()
                .filter(c -> c.getValue() != 0)
                .forEach(c -> System.out.printf(" # %s --> %d%n", c.getKey(), c.getValue()));
    }
}

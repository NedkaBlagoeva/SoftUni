package ExamPrep.RetakeExam18August2021;

import java.util.*;
import java.util.stream.Collectors;

public class _01_PastryShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> liquidsDeque = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredientsStack::push);

        int sum = 0;
        Map<String, Integer> foodToBake = new LinkedHashMap<>();
        foodToBake.put("Biscuit", 0);
        foodToBake.put("Cake", 0);
        foodToBake.put("Pie", 0);
        foodToBake.put("Pastry", 0);

        while (!(liquidsDeque.isEmpty() || ingredientsStack.isEmpty())) {
            sum = liquidsDeque.peek() + ingredientsStack.peek();
            switch (sum) {
                case 25:
                    ingredientsStack.pop();
                    foodToBake.put("Biscuit", foodToBake.get("Biscuit") + 1);
                    break;
                case 50:
                    ingredientsStack.pop();
                    foodToBake.put("Cake", foodToBake.get("Cake") + 1);
                    break;
                case 75:
                    ingredientsStack.pop();
                    foodToBake.put("Pastry", foodToBake.get("Pastry") + 1);
                    break;
                case 100:
                    ingredientsStack.pop();
                    foodToBake.put("Pie", foodToBake.get("Pie") + 1);
                    break;
                default:
                    Integer last = ingredientsStack.pop() + 3;
                    ingredientsStack.push(last);
                    break;
            }
            liquidsDeque.poll();
        }
        boolean areAllCooked = true;
        for (Integer value : foodToBake.values()) {
            if (value == 0) {
                areAllCooked = false;
                break;
            }
        }
        if (areAllCooked) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsDeque.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            print(liquidsDeque);
        }
        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: ");
            print(ingredientsStack);
        }
        foodToBake.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static void print(ArrayDeque<Integer> ingredientsStack) {
        String ingredientsToString = ingredientsStack.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(ingredientsToString);
    }
}

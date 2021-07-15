package _08_MapsLambdaAndStreamAPI.Lab;

import java.util.*;

public class _01_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] numbers = Arrays.stream(scan.nextLine()
                .split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> counts = new TreeMap<>();
        for (double number : numbers) {
            if (!counts.containsKey(number)) {
                counts.put(number, 0);
            }
            counts.put(number, counts.get(number) + 1);
        }
        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}

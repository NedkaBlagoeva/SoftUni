package _08_MapsLambdaAndStreamAPI.Exercise;

import java.util.*;

public class _04_Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Double>> products = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!"buy".equals(input)) {
            String product = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            double quantity = Double.parseDouble(input.split(" ")[2]);
            if (!products.containsKey(product)){
                products.put(product, new ArrayList<>());
                products.get(product).add(price);
                products.get(product).add(quantity);
            } else {
                products.get(product).set(0,price);
                products.get(product).set(1, (products.get(product).get(1) + quantity));
            }
                input = scan.nextLine();
        }
        for (Map.Entry <String, List<Double>> entry : products.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue().get(0) * entry.getValue().get(1));
        }
    }
}

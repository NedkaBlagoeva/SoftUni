package _08_MapsLambdaAndStreamAPI.Exercise;

import java.util.*;

public class _03_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new HashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();
        boolean weHaveWinner = false;
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        while (!weHaveWinner) {
            String[] input = scan.nextLine().toLowerCase().split("\\s+");
            for (int i = 0; i < input.length; i++) {
                if (weHaveWinner){
                    break;
                }
                if (i % 2 != 0) {
                    switch (input[i]) {
                        case "shards":
                        case "fragments":
                        case "motes":
                            int quantity = Integer.parseInt(input[i - 1]);
                            keyMaterials.put(input[i], keyMaterials.get(input[i]) + quantity);
                            if (keyMaterials.get(input[i]) >= 250) {
                                weHaveWinner = true;
                                findWinner(keyMaterials);
                                keyMaterials.put(input[i], keyMaterials.get(input[i]) - 250);
                            }
                            break;
                        default:
                            junkMaterials.putIfAbsent(input[i], 0);
                            int quantity1 = Integer.parseInt(input[i - 1]);
                            junkMaterials.put(input[i], junkMaterials.get(input[i]) + quantity1);
                            break;
                    }

                }
            }
        }
        keyMaterials
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(result -> System.out.printf("%s: %d%n", result.getKey(), result.getValue()));
        junkMaterials.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

    }

    private static void findWinner(Map<String, Integer> keyMaterials) {
        String winner = "";
        for (var entry : keyMaterials.entrySet()) {
            if (entry.getValue() >= 250) {
                switch (entry.getKey()) {
                    case "shards":
                        winner = "Shadowmourne";
                        break;
                    case "fragments":
                        winner = "Valanyr";
                        break;
                    case "motes":
                        winner = "Dragonwrath";
                        break;
                    default:
                        break;
                }
                System.out.printf("%s obtained!%n", winner);

            }
        }
    }
}

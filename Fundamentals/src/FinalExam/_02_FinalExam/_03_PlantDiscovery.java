package FinalExam._02_FinalExam;

import java.util.*;

public class _03_PlantDiscovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> plants = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] plantsInfo = scan.nextLine().split("<->");
            String plantName = plantsInfo[0];
            double rarity = Integer.parseInt(plantsInfo[1]);
            plants.put(plantName, new ArrayList<>());
            plants.get(plantName).add(rarity);
        }

        String input = scan.nextLine();
        while (!"Exhibition".equals(input)) {
            String[] commandParts = input.split(": | - ");
            String command = commandParts[0];
            String plantName = commandParts[1];
            if (!plants.containsKey(plantName)) {
                input = scan.nextLine();
                System.out.println("error");
                continue;
            }

            switch (command) {
                case "Rate":
                    //Rate: {plant} - {rating} – add the given rating to the plant (store all ratings)
                    double rating = Integer.parseInt(commandParts[2]);
                    plants.get(plantName).add(rating);
                    break;
                case "Update":
                    //Update: {plant} - {new_rarity} – update the rarity of the plant with the new one
                    double newRarity = Integer.parseInt(commandParts[2]);
                    plants.get(plantName).set(0, newRarity);
                    break;
                case "Reset":
                    //Reset: {plant} – remove all the ratings of the given plant
                    double rarity = plants.get(plantName).get(0);
                    plants.get(plantName).clear();
                    plants.get(plantName).add(rarity);
                    break;
            }
            input = scan.nextLine();
        }
        for (Map.Entry<String, List<Double>> entry : plants.entrySet()) {
            entry.getValue().add(1, getAverageRating(entry.getValue()));
        }

        System.out.println("Plants for the exhibition:");
        plants
                .entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int result = Double.compare(p2.getValue().get(0), p1.getValue().get(0));
                    if (result == 0) {
                        result = Double.compare(p2.getValue().get(1), p1.getValue().get(1));
                    }
                    return result;
                })
                .forEach(p -> System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n",
                        p.getKey(),
                        p.getValue().get(0),
                        p.getValue().get(1)));
    }
    public static double getAverageRating (List<Double> list){
        double allRatings = 0;
        for (int i = 1; i < list.size(); i++) {
            allRatings += list.get(i);
        }
        if (allRatings == 0){
            return 0;
        }
        return allRatings / (list.size() - 1);
    }
}


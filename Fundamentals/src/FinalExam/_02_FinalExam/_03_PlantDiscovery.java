package FinalExam._02_FinalExam;

import java.util.*;

public class _03_PlantDiscovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, PlansData> plants = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] plantsInfo = scan.nextLine().split("<->");
            String plantName = plantsInfo[0];
            int rarity = Integer.parseInt(plantsInfo[1]);
            plants.put(plantName, new PlansData(rarity, new ArrayList<>()));
            // plants.get(plantName).getRatings().add(0);
        }

        String input = scan.nextLine();
        while (!"Exhibition".equals(input)) {
            input = input.replace(" ", "");
            String[] commandParts = input.split("[:-]");
            String command = commandParts[0];
            String plantName = commandParts[1];
            switch (command) {
                case "Rate":
                    //Rate: {plant} - {rating} – add the given rating to the plant (store all ratings)
                    int rating = Integer.parseInt(commandParts[2]);
                    plants.get(plantName).getRatings().add(rating);
                    break;
                case "Update":
                    //Update: {plant} - {new_rarity} – update the rarity of the plant with the new one
                    int newRarity = Integer.parseInt(commandParts[2]);
                    plants.get(plantName).setRarity(newRarity);
                    break;
                case "Reset":
                    //Reset: {plant} – remove all the ratings of the given plant
                    plants.get(plantName).getRatings().clear();
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            input = scan.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plants
                .entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int result = Integer.compare(p2.getValue().getRarity(), p1.getValue().getRarity());
                    if (result == 0) {
                        result = Double.compare(p2.getValue().getAverageRating(), p1.getValue().getAverageRating());
                    }
                    return result;
                })
                .forEach(p -> System.out.printf("- %s; Rarity: %s; Rating: %.2f%n",
                        p.getKey(),
                        p.getValue().getRarity(),
                        p.getValue().getAverageRating()));
    }
}

class PlansData {
    int rarity;
    List<Integer> ratings;

    public PlansData(int rarity, List<Integer> ratings) {
        this.rarity = rarity;
        this.ratings = ratings;
    }

    public int getRarity() {
        return rarity;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public double getAverageRating() {
        double sumOfRatings = 0.0;
        for (Integer rating : this.ratings) {
            sumOfRatings += rating;
        }
        if (sumOfRatings == 0) {
            return 0;
        } else {
            return sumOfRatings / this.ratings.size();
        }
    }
}

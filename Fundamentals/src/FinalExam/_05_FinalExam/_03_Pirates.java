package FinalExam._05_FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, TownInfo> towns = new LinkedHashMap<>();
        while (!"Sail".equals(input)) {
            String[] tokens = input.split("\\|\\|");
            String townName = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);
            if (!towns.containsKey(townName)) {
                towns.putIfAbsent(townName, new TownInfo(population, gold));
            } else {
                int currentPopulation = towns.get(townName).getPopulation();
                int currentGold = towns.get(townName).getGold();
                towns.get(townName).setPopulation(currentPopulation + population);
                towns.get(townName).setGold(currentGold + gold);
            }
            input = scan.nextLine();
        }
        String events = scan.nextLine();
        while (!"End".equals(events)) {
            String[] eventsParts = events.split("=>");
            String eventName = eventsParts[0];
            String townName = eventsParts[1];
            switch (eventName) {
                case "Plunder":
                    int peopleKilled = Integer.parseInt(eventsParts[2]);
                    int goldToSteal = Integer.parseInt(eventsParts[3]);
                    int currentPopulation = towns.get(townName).getPopulation();
                    towns.get(townName).setPopulation(currentPopulation - peopleKilled);
                    int currentGold = towns.get(townName).getGold();
                    towns.get(townName).setGold(currentGold - goldToSteal);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", townName, goldToSteal, peopleKilled);
                    if (towns.get(townName).getPopulation() <= 0 || towns.get(townName).getGold() <= 0) {
                        towns.remove(townName);
                        System.out.printf("%s has been wiped off the map!%n", townName);
                    }
                    break;
                case "Prosper":
                    int goldToProsper = Integer.parseInt(eventsParts[2]);
                    if (goldToProsper >= 0) {
                        int goldNow = towns.get(townName).getGold();
                        towns.get(townName).setGold(goldNow + goldToProsper);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                goldToProsper, townName, towns.get(townName).getGold());
                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
                default:
                    break;
            }
            events = scan.nextLine();
        }
        if (towns.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", towns.size());
            towns.entrySet().stream().sorted((t1, t2) -> {
                int result = Integer.compare(t2.getValue().getGold(), t1.getValue().getGold());
                if (result == 0) {
                    result = t1.getKey().compareTo(t2.getKey());
                }
                return result;
            }).forEach(town -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                    town.getKey(), town.getValue().getPopulation(), town.getValue().getGold()));
        }
    }

    private static class TownInfo {
        private int population;
        private int gold;

        public TownInfo(int population, int gold) {
            this.population = population;
            this.gold = gold;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }
    }
}

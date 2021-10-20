package _06_DefiningClasses.Exercise._06_PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            //"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}"
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.putIfAbsent(trainerName, new Trainer());
            trainers.get(trainerName).addPokemon(pokemon);
            input = scan.nextLine();
        }

        String commandElement = scan.nextLine(); //"Fire", "Water", "Electricity"
        while (!commandElement.equals("End")) {
            for (Trainer trainer : trainers.values()) {
                trainer.increaseBadges(commandElement);
            }
            commandElement = scan.nextLine();
        }

        trainers
                .entrySet()
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue().getNumberOfBadges(), t1.getValue().getNumberOfBadges()))
                .forEach(t -> System.out.printf("%s %d %d%n", t.getKey(), t.getValue().getNumberOfBadges(), t.getValue().getListSize()));
    }
}

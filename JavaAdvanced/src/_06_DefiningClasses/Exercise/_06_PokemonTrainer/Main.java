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
            trainers.putIfAbsent(trainerName, new Trainer(trainerName, new ArrayList<>()));
            trainers.get(trainerName).getPokemonCollection().add(pokemon);
            input = scan.nextLine();
        }
        String commandElement = scan.nextLine(); //"Fire", "Water", "Electricity"
        while (!commandElement.equals("End")) {
            for (Trainer trainer : trainers.values()) {

            }
            for (Map.Entry<String, Trainer> trainerEntry : trainers.entrySet()) {
                List<Pokemon> pokemons = trainerEntry.getValue().getPokemonCollection();
                for (Pokemon pokemon : pokemons) {
                    if (pokemon.getElement().equals(commandElement)) {
                        int trainerBadges = trainerEntry.getValue().getNumberOfBadges();
                        trainerEntry.getValue().setNumberOfBadges(trainerBadges + 1);
                    } else {
                        int pokemonHealth = pokemon.getHealth();
                        pokemon.setHealth(pokemonHealth - 10);
                        if (pokemon.getHealth() <= 0) {
                            pokemons.remove(pokemon);
                        }
                    }
                }
            }
            commandElement = scan.nextLine();
        }
        trainers
                .entrySet()
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue().getNumberOfBadges(), t1.getValue().getNumberOfBadges()))
                .forEach(t -> System.out.printf("%s %d %d%n", t.getValue().getName(), t.getValue().getNumberOfBadges(), t.getValue().getListSize()));
    }
}

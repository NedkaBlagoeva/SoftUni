package _06_DefiningClasses.Exercise._06_PokemonTrainer;

import java.util.LinkedList;
import java.util.List;

public class Trainer {
    //name, number of badges and a collection of pokemon
    private int numberOfBadges;
    List<Pokemon> pokemonCollection;

    public Trainer() {
        this.pokemonCollection = new LinkedList<>();
        this.numberOfBadges = 0;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public int getListSize() {
        if (pokemonCollection.isEmpty()) {
            return 0;
        }
        return pokemonCollection.size();
    }

    public void addPokemon(Pokemon pokemon) {
        pokemonCollection.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon) {
        pokemonCollection.remove(pokemon);
    }

    public void increaseBadges(String element) {
        for (Pokemon pokemon : pokemonCollection) {
            if (pokemon.getElement().equals(element)) {
                this.numberOfBadges++;
            } else {
                pokemon.reduceHealth();
                if (pokemon.getHealth() <= 0) {
                    removePokemon(pokemon);
                }
            }
        }
    }

}

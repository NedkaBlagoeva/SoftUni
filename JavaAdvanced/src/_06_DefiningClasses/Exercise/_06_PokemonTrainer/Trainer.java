package _06_DefiningClasses.Exercise._06_PokemonTrainer;

import java.util.List;

public class Trainer {
    //name, number of badges and a collection of pokemon
    private final String name;
    private int numberOfBadges = 0;
    List<Pokemon> pokemonCollection;

    public Trainer(String name, List<Pokemon> pokemonCollection) {
        this.name = name;
        this.pokemonCollection = pokemonCollection;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public List<Pokemon> getPokemonCollection() {
        return pokemonCollection;
    }

    public int getListSize (){
        if (pokemonCollection.isEmpty()){
            return 0;
        }
        return pokemonCollection.size();
    }
}

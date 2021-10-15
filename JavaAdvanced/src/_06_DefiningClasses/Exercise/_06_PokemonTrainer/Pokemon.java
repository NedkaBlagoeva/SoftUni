package _06_DefiningClasses.Exercise._06_PokemonTrainer;

public class Pokemon {
    //name, an element and health, all values are mandatory
    private final String name;
    private final String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

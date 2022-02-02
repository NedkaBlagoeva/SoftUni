package main.java.aquarium.entities.fish;

public class SaltwaterFish extends BaseFish{

    private int size;
    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.size = 5;
    }

    @Override
    public void eat() {
        this.size += 2;
    }
}

package main.java.aquarium.entities.aquariums;

import main.java.aquarium.common.ConstantMessages;
import main.java.aquarium.common.ExceptionMessages;
import main.java.aquarium.entities.decorations.BaseDecoration;
import main.java.aquarium.entities.decorations.Decoration;
import main.java.aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseAquarium implements Aquarium {

    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.capacity > this.fish.size()) {
            this.fish.add(fish);
        } else {
            throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder report = new StringBuilder();
        report
                .append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator());
        if (this.fish.isEmpty()) {
            report
                    .append("none");
        } else {
            for (Fish f : fish) {
                report
                        .append(f.getName())
                        .append(" ");
            }
            report
                    .append("Decorations: ").append(decorations.size())
                    .append(System.lineSeparator()).append("Comfort: ").append(this.calculateComfort())
                    .append(System.lineSeparator());
        }

        return report.toString();
    }

    @Override
    public Collection<Fish> getFish() {
        return fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }
}

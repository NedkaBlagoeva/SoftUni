package _06_ObjectsAndClasses.Exercise.VehicleCatalogue;

public class Vehicle {
    private String type;
    private String model;
    private String color;
    private int hp;

    public Vehicle(String type, String model, String color, int hp) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.hp = hp;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {

        String typeUpper = this.type.substring(0, 1).toUpperCase() + this.type.substring(1);
        return String.format("Type: %s%n" +
                "Model: %s%n" +
                "Color: %s%n" +
                "Horsepower: %d", typeUpper, this.model, this.color, this.hp);
    }
}

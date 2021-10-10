package _06_DefiningClasses.Exercise._05_CarSalesman;

public class Car {
    //model, engine, weight and color
    //Car's weight, color, its Engine’s displacements, and efficiency are optional
    private final String model;
    private final Engine engine;
    private int weight = 0;
    private String color = "n/a";

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    @Override
    public String toString() {
        String printWeight;
        if (weight == 0){
            printWeight = "n/a";
        } else {
            printWeight = "" + weight;
        }

        String printDisplacement;
        if (engine.getDisplacement() == 0){
            printDisplacement = "n/a";
        } else {
            printDisplacement = "" + engine.getDisplacement();
        }
        return String.format("%s:%n" +
                        "%s:%n" +
                "Power: %d%n" +
                "Displacement: %s%n" +
                "Efficiency: %s%n" +
                "Weight: %s%n" +
                "Color: %s", model, engine.getModel(), engine.getPower(), printDisplacement, engine.getEfficiency(),
                printWeight, color);

}
}

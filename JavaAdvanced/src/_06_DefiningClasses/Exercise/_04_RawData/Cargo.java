package _06_DefiningClasses.Exercise._04_RawData;

public class Cargo {
    //{CargoWeight} {CargoType}
    private final int weight;
    private final String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

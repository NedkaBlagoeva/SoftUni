package _06_DefiningClasses.Exercise._04_RawData;

public class Engine {
    //{EngineSpeed} {EnginePower}
    private final int speed;
    private final int power;

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}

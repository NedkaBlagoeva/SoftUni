package _06_DefiningClasses.Exercise._04_RawData;

public class Tire {
    //{Tire1Pressure} {Tire1Age}
    private final double pressure;
    private final int age;

    public Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }
}

package _06_DefiningClasses.Exercise._03_SpeedRacing;

public class Car {
    //information Model, fuel amount, fuel cost for 1 kilometer and distance traveled
    private final String model;
    private double fuelAmount;
    private final double fuelCost;
    private double distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public boolean canDrive (double distance){
        double fuelNeeded = distance * this.fuelCost;
        if (fuelNeeded <= this.fuelAmount){
            this.distanceTraveled += distance;
            this.fuelAmount -= fuelNeeded;
            return true;
        }
        return false;
    }
}

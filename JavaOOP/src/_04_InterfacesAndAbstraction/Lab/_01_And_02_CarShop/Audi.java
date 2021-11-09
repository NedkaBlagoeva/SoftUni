package _04_InterfacesAndAbstraction.Lab._01_And_02_CarShop;

public class Audi extends CarImpl implements Rentable {
    private final Integer days;
    private final Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer days, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.days = days;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.days;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Minimum rental period of %d days. Price per day %f", this.days, this.pricePerDay);
    }
}

package _04_InterfacesAndAbstraction.Lab._01_And_02_CarShop;

public class Seat extends CarImpl implements Sellable{
    private final Double price;

    public Seat(String model, String color, Integer horsePower, String country, Double price) {
        super(model, color,horsePower, country);
        this.price = price;
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public Integer getHorsePower() {
        return super.getHorsePower();
    }

    @Override
    public String countryProduced() {
        return super.countryProduced();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%s sells for %f", this.getModel(), this.price);
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}

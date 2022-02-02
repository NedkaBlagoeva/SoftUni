package restaurant.entities.healthyFoods;

import restaurant.common.ExceptionMessages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

public abstract class Food implements HealthyFood {

    private String name;
    private double portion;
    private double price;

    protected Food(String name, double portion, double price) {
       setName(name);
       setPortion(portion);
       setPrice(price);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        this.name = name;
    }

    public void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PORTION);
        }
        this.portion = portion;
    }

    public void setPrice(double price) {
        if (price <= 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

package restaurant.entities.drinks;

public class Fresh extends BaseBeverage{
    private static final double freshPrice = 3.50;

    public Fresh(String name, int counter, String brand) {
        super(name, counter, freshPrice, brand);
    }
}

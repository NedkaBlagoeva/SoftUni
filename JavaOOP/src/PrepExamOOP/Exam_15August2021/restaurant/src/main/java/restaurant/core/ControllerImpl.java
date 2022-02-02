package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Food;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

public class ControllerImpl implements Controller {


    private final HealthFoodRepository<HealthyFood> healthFoodRepository;
    private final BeverageRepository<Beverages> beverageRepository;
    private final TableRepository<Table> tableRepository;
    private double totalMoney;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {

        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;

    }

    @Override
    public String addHealthyFood(String type, double price, String name) {

        HealthyFood food = type.equals("Salad")
                ? new Salad(name, price)
                : new VeganBiscuits(name, price);

        if (healthFoodRepository.foodByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
        } else {
            healthFoodRepository.add(food);
            return String.format(OutputMessages.FOOD_ADDED, food.getName());
        }
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverage = type.equals("Fresh")
                ? new Fresh(name, counter, brand)
                : new Smoothie(name, counter, brand);

        if (beverageRepository.beverageByName(name, brand) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, beverage.getName()));
        } else {
            beverageRepository.add(beverage);
            return String.format(OutputMessages.BEVERAGE_ADDED, type, beverage.getBrand());
        }
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = type.equals("Indoors")
                ? new Indoors(tableNumber, capacity)
                : new InGarden(tableNumber, capacity);

        if (tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED, table.getTableNumber()));
        } else {
            tableRepository.add(table);
            return String.format(OutputMessages.TABLE_ADDED, table.getTableNumber());
        }
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table table = tableRepository.getAllEntities().stream()
                .filter(t -> t.getSize() >= numberOfPeople && !t.isReservedTable())
                .findFirst()
                .orElse(null);
        String output;
        if (table == null) {
            output = String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        } else {
            table.reserve(numberOfPeople);
            output = String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
        }
        return output;
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);
        HealthyFood food = healthFoodRepository.foodByName(healthyFoodName);

        if (table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }

        if (food == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);
        }

        table.orderHealthy(food);
        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);
        Beverages beverage = beverageRepository.beverageByName(name, brand);

        if (table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }

        if (beverage == null) {
            return String.format(OutputMessages.NON_EXISTENT_DRINK, name, brand);
        }

        table.orderBeverages(beverage);
        return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tableRepository.byNumber(tableNumber);
        double bill = table.bill();
        totalMoney += bill;
        return String.format(OutputMessages.BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        return String.format(OutputMessages.TOTAL_MONEY, totalMoney);
    }
}

package restaurant.entities.tables;

import restaurant.common.enums.TableType;
import restaurant.entities.tables.BaseTable;

public class InGarden extends BaseTable {

    private static final double pricePerPerson = 4.50;

    public InGarden(int number, int size) {
        super(number, size, pricePerPerson);
    }

    @Override
    public String tableInformation() {
        return String.format("Table - %d%n" +
                        "Size - %d%n" +
                        "Type - %s%n" +
                        "All price - %.2f",
                this.getTableNumber(), this.getSize(), TableType.InGarden, this.pricePerPerson()
        );
    }
}

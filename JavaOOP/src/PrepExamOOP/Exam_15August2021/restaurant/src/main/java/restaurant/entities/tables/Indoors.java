package restaurant.entities.tables;

import restaurant.common.enums.TableType;

public class Indoors extends BaseTable {

    private static final double pricePerPerson = 3.50;

    public Indoors(int number, int size) {
        super(number, size, pricePerPerson);
    }

    @Override
    public String tableInformation() {
        return String.format("Table - %d%n" +
                        "Size - %d%n" +
                        "Type - %s%n" +
                        "All price - %.2f",
                this.getTableNumber(), this.getSize(), TableType.Indoors, this.pricePerPerson()
        );
    }
}

package _06_DefiningClasses.Lab._02_CarConstructors;

public class Car {
    private String brand;
    private String model;
    private int horsePower;


    public Car(String brand){
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car (String brand, String model, int horsePower){
        this(brand);
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel (){
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void carInfo(){
        System.out.printf("The car is: %s %s - %d HP.%n", this.brand, this.model, this.horsePower);
    }
}

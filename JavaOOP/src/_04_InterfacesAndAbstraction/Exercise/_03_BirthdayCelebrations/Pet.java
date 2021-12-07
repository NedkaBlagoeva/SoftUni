package _04_InterfacesAndAbstraction.Exercise._03_BirthdayCelebrations;

public class Pet implements Birthable {
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate){
        this.birthDate = birthDate;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}

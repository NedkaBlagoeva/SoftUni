package _06_DefiningClasses.Exercise._02_CompanyRoster;

public class Employee {
    //name, salary, position, department, email and age
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee (String name, double salary, String position, String department){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = 0;
    }
}

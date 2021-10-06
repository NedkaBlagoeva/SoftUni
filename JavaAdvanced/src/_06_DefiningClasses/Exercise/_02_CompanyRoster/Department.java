package _06_DefiningClasses.Exercise._02_CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department (String name){
        this.name = name;
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double averageSalary (){
        return employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }

}

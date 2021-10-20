package ExamPrep.RetakeExam18August2021.cafe;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new LinkedList<>();
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        return employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparing(Employee::getAge)).get();
    }

    public Employee getEmployee(String name) {
        Employee employee = null;
        for (Employee value : employees) {
            if (value.getName().equals(name)) {
                employee = value;
            }
        }
        return employee;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Employees working at Cafe ").append(name).append(":").append(System.lineSeparator());
        for (Employee employee : employees) {
            report.append(employee ).append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}



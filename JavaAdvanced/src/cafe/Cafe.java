package cafe;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cafe {
    private String name;
    private int capacity;
    private Map<String, Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new LinkedHashMap<>();
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < capacity) {
            employees.put(employee.getName(), employee);
        }
    }

    public boolean removeEmployee(String name) {
        Employee employee = this.employees.remove(name);
        return employee != null;
    }

    public Employee getOldestEmployee() {
        return employees.values().stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name) {
        return employees.get(name);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Employees working at Cafe ").append(name).append(":").append(System.lineSeparator());
        for (Employee employee : employees.values()) {
            report.append(employee).append(System.lineSeparator());
        }
        return report.toString();
    }
}



package _06_DefiningClasses.Exercise._02_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Department> departments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputData = scan.nextLine().split("\\s+"); //name, salary, position, department, email, age
            String name = inputData[0];
            double salary = Double.parseDouble(inputData[1]);
            String position = inputData[2];
            String department = inputData[3];
            Employee employee = null;
            if (inputData.length == 4) {
                employee = new Employee(name, salary, position, department);

            } else if (inputData.length == 6) {
                String email = inputData[4];
                int age = Integer.parseInt(inputData[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (inputData.length == 5) {
                try {
                    int age = Integer.parseInt(inputData[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException e) {
                    String email = inputData[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }
            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getEmployees().add(employee);
        }
        Department highestSalaryDepartment = departments
                .entrySet()
                .stream()
                .max(Comparator.comparing(e -> e.getValue().averageSalary()))
                .get()
                .getValue();
        System.out.println("Highest Average Salary: " + highestSalaryDepartment.getName());

        highestSalaryDepartment
                .getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}

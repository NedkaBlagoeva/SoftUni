package _08_MapsLambdaAndStreamAPI.Exercise;

import java.util.*;

public class _08_CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, List<String>> employees = new TreeMap<>();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" -> ");
            String companyName = tokens[0];
            String employeeID = tokens[1];
            employees.putIfAbsent(companyName, new ArrayList<>());
            if (!employees.get(companyName).contains(employeeID)) {
                employees.get(companyName).add(employeeID);
            }
            input = scan.nextLine();
        }
        employees.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.forEach(EmployeeID -> System.out.println("-- " + EmployeeID));
        });
    }
}

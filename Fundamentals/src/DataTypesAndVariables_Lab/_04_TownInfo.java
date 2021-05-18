package DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _04_TownInfo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String town = scan.nextLine();
        int population = Integer.parseInt(scan.nextLine());
        double area = Double.parseDouble(scan.nextLine());
        System.out.printf("Town %s has population of %d and area %.0f square km.", town, population, area);
    }
}

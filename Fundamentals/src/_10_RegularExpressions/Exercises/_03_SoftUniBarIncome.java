package _10_RegularExpressions.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = "%(?<customer>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>\\d+)\\|[^0-9.|$%]*(?<price>[0-9]+.?\\d*)\\$";
        Pattern pattern = Pattern.compile(regex);

        double totalIncome = 0;
        while (!"end of shift".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String customer = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double totalPrice = count * price;
                System.out.printf("%s: %s - %.2f%n", customer, product, totalPrice);
                totalIncome += totalPrice;
            }
            input = scan.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}

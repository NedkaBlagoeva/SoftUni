package _10_RegularExpressions.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>\\d+.?\\d*)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        double totalMoney = 0;
        System.out.println("Bought furniture:");
        while (!"Purchase".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println(matcher.group("furniture"));
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalMoney += price * quantity;
            }
            input = scan.nextLine();
        }
        System.out.printf("Total money spend: %.2f", totalMoney);
    }
}

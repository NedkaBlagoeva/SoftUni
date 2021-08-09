package FinalExam._01_FinalExamRetake;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_AdAstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "(?<separator>[#\\|])(?<product>[A-Za-z\\s]+)\\1(?<expday>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<kcal>\\d+)\\1";
        String products = scan.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(products);
        int allKcal = 0;
        while (matcher.find()) {
            allKcal += Integer.parseInt(matcher.group("kcal"));
        }
        System.out.printf("You have food to last you for: %d days!%n", allKcal / 2000);
        Matcher matcher1 = pattern.matcher(products);
        while (matcher1.find()) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n",
                    matcher1.group("product"), matcher1.group("expday"), matcher1.group("kcal"));
        }
    }
}

package ConditionalStatements_Exercise;

import java.util.Scanner;

public class GodzillaVsKong_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int statists = Integer.parseInt(scan.nextLine());
        double clothesPrice = Double.parseDouble(scan.nextLine());

        double decor = budget * 0.1;
        double clothes = statists * clothesPrice;
        if (statists >= 150) {
            clothes *= 0.9;
        }
        double moneyNeeded = clothes + decor;
        if (moneyNeeded > budget) {
            System.out.printf("Not enough money!%nWingard needs %.2f leva more.", moneyNeeded - budget);
        } else {
            System.out.printf("Action!%nWingard starts filming with %.2f leva left.", budget - moneyNeeded);
        }


    }
}

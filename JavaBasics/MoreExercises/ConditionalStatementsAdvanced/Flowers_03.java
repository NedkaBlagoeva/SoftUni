package MoreExercises.ConditionalStatementsAdvanced;

import java.util.Scanner;

public class Flowers_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int chrysanthemums = Integer.parseInt(scan.nextLine());
        int roses = Integer.parseInt(scan.nextLine());
        int tulips = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        String holiday = scan.nextLine();
        double priceCh = 0.0;
        double priceR = 0.0;
        double priceT = 0.0;
        double priceBouquet = 0.0;
//            Сезон	            Хризантеми	    Рози	        Лалета
//            Пролет / Лято	    2.00 лв./бр.	4.10 лв./бр.	2.50 лв./бр.
//            Есен / Зима	    3.75 лв./бр.	4.50 лв./бр.	4.15 лв./бр.

        switch (season) {
            case "Spring":
            case "Summer":
                priceCh = 2.0;
                priceR = 4.10;
                priceT = 2.5;
                break;
            case "Autumn":
            case "Winter":
                priceCh = 3.75;
                priceR = 4.50;
                priceT = 4.15;
                break;
        }
        priceBouquet = priceCh * chrysanthemums + priceR * roses + priceT * tulips;
        if (holiday.equals("Y")) {
            priceBouquet *= 1.15;
        }
        if (tulips >= 7 && season.equals("Spring")) {
            priceBouquet *= 0.95;
        }
        if (roses >= 10 && season.equals("Winter")) {
            priceBouquet *= 0.90;
        }
        if (chrysanthemums + roses + tulips >= 20) {
            priceBouquet *= 0.80;
        }
        System.out.printf("%.2f", priceBouquet + 2);
    }
}

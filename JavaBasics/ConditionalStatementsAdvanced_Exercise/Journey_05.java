package ConditionalStatementsAdvanced_Exercise;

import java.util.Scanner;

public class Journey_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String destination = "";
        String tripType = "";
//•При 100 лв.или по -малко –някъде в България
//        o Лято –30 % от бюджета
//        o Зима –70 % от бюджета
//•При 1000 лв.или по малко –някъде на Балканите
//        o Лято –40 % от бюджета
//        o Зима –80 % от бюджета
//•При повече от 1000 лв. –някъде из Европа
//        o При пътуване из Европа, независимо от сезона ще похарчи 90 % от бюджета.

        if (budget <= 100) {
            destination = "Bulgaria";
            switch (season) {
                case "summer":
                    tripType = "Camp";
                    budget *= 0.30;
                    break;
                case "winter":
                    tripType = "Hotel";
                    budget *= 0.70;
                    break;
            }
        } else if (budget<=1000){
            destination = "Balkans";
            switch (season) {
                case "summer":
                    tripType = "Camp";
                    budget *= 0.40;
                    break;
                case "winter":
                    tripType = "Hotel";
                    budget *= 0.80;
                    break;
            }
        }else {
            destination = "Europe";
            tripType = "Hotel";
            budget *=0.90;
        }
        System.out.printf("Somewhere in %s%n%s - %.2f",destination, tripType,budget);
    }
}

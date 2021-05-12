package Exam18_19July2020;

import java.util.Scanner;

public class AgencyProfit_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String company = scan.nextLine();
        int ticketsAdults = Integer.parseInt(scan.nextLine());
        int ticketsChildren = Integer.parseInt(scan.nextLine());
        double priceAdults = Double.parseDouble(scan.nextLine());
        double taxService = Double.parseDouble(scan.nextLine());

        double priceChildren = priceAdults * 0.30;
        double totalChildren = ticketsChildren * (priceChildren + taxService);
        double totalAdult = ticketsAdults * (priceAdults + taxService);
        double profit = (totalChildren + totalAdult) * 0.2;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", company, profit);

    }
}

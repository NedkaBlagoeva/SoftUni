package ConditionalStatementsAdvanced_Lab;

import java.util.Scanner;

public class SkiTrip_13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        String roomType = scan.nextLine();
        String rating = scan.nextLine();
        int nights = days - 1;
        double price = 0.0;
        double bill = 0.0;

        switch (roomType) {
            case "room for one person":
                price = 18.00;
                bill = nights * price;
                break;
            case "apartment":
                price = 25.00;
                if (nights < 10) {
                    bill = nights * price * 0.7;
                } else if (nights <= 15) {
                    bill = nights * price * 0.65;
                } else {
                    bill = nights * price * 0.50;
                }
                break;
            case "president apartment":
                price = 35.00;
                if (nights < 10) {
                    bill = nights * price * 0.9;
                } else if (nights <= 15) {
                    bill = nights * price * 0.85;
                } else {
                    bill = nights * price * 0.80;
                    break;
                }

        }
        if (rating.equals("positive")) {
            bill = bill + bill*0.25;
        } else if (rating.equals("negative")) {
            bill = bill*0.9;
        }
        System.out.printf("%.2f", bill);
    }
}


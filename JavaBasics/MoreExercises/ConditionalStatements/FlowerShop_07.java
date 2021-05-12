package MoreExercises.ConditionalStatements;

import java.util.Scanner;

public class FlowerShop_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int magnolii = Integer.parseInt(scan.nextLine());
        int ziumbiuls = Integer.parseInt(scan.nextLine());
        int roses = Integer.parseInt(scan.nextLine());
        int cactuses = Integer.parseInt(scan.nextLine());
        double giftPrice = Double.parseDouble(scan.nextLine());

        double mPrice = magnolii * 3.25;
        double zPrice = ziumbiuls * 4.00;
        double rPrice = roses * 3.50;
        double cPrice = cactuses * 8.00;

        double moneyFromOrder = (mPrice + zPrice + rPrice + cPrice)*0.95;
        if (moneyFromOrder >= giftPrice){
            System.out.printf("She is left with %.0f leva.",Math.floor(moneyFromOrder-giftPrice));
        }else{
            System.out.printf("She will have to borrow %.0f leva.",Math.ceil(giftPrice-moneyFromOrder));
        }

    }
}

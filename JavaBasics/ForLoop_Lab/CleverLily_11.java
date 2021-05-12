package ForLoop_Lab;

import java.util.Scanner;

public class CleverLily_11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double priceWashingMachine = Double.parseDouble(scan.nextLine());
        int toyPrice = Integer.parseInt(scan.nextLine());

        double sumMoney = 0.0;
        double sumToys = 0.0;
        int countToys = 0;
        int money = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                money += 10;
                sumMoney += money - 1;
            } else {
                countToys++;
                sumToys = toyPrice * countToys;
            }
        }
        double diff = Math.abs(sumMoney + sumToys - priceWashingMachine);
        if (sumMoney + sumToys >= priceWashingMachine){
            System.out.printf("Yes! %.2f", diff);
        }else{
            System.out.printf("No! %.2f", diff);
        }



    }
}

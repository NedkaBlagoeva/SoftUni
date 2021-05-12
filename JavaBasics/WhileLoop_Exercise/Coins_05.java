package WhileLoop_Exercise;

import java.util.Scanner;

public class Coins_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double change = Double.parseDouble(scan.nextLine())*100;
        int countCoins = 0;

        while (change >= 200) {
            change -= 200;
            countCoins++;
        }
        while (change >= 100) {
            change -= 100;
            countCoins++;
        }
        while (change >= 50) {
            change -= 50;
            countCoins++;
        }
        while (change >= 20) {
            change -= 20;
            countCoins++;
        }
        while (change >= 10) {
            change -= 10;
            countCoins++;
        }
        while (change >= 5) {
            change -= 5;
            countCoins++;
        }
        while (change >= 2) {
            change -= 2;
            countCoins++;
        }
        while (change >= 1) {
            change -= 1;
            countCoins++;
        }
        System.out.println(countCoins);
    }
}

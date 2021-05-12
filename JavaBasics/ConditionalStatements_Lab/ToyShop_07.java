package ConditionalStatements_Lab;
import java.util.Scanner;

public class ToyShop_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double tripPrice = Double.parseDouble(scan.nextLine());
        int countPuzzle = Integer.parseInt(scan.nextLine());
        int countDoll = Integer.parseInt(scan.nextLine());
        int countTeddyBear = Integer.parseInt(scan.nextLine());
        int countMinion = Integer.parseInt(scan.nextLine());
        int countTruck = Integer.parseInt(scan.nextLine());
        int countAll = countPuzzle + countDoll + countTeddyBear + countMinion + countTruck;
        double puzzlePrice = countPuzzle*2.60;
        double dollPrice = countDoll*3.00;
        double teddyBearPrice = countTeddyBear*4.10;
        double minionPrice = countMinion*8.20;
        double truckPrice = countTruck*2.00;
        double priceForAll = puzzlePrice+dollPrice+teddyBearPrice+minionPrice+truckPrice;
        double endProfit;
        if (countAll>=50) {
            endProfit = priceForAll - priceForAll*0.25;
            endProfit = endProfit - endProfit*0.1;
        } else {
            endProfit = priceForAll - priceForAll*0.1;
        }
        double moneyLeft = endProfit - tripPrice;


        if (tripPrice<=endProfit) {
            System.out.printf("Yes! %.2f lv left.", Math.abs(moneyLeft));
        } else System.out.printf("Not enough money! %.2f lv needed.", Math.abs(moneyLeft));
    }
}

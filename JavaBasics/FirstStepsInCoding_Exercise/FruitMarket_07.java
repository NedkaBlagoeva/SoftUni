package FirstStepsInCoding_Exercise;
import java.util.Scanner;

public class FruitMarket_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double strawberryPrice = Double.parseDouble(scan.nextLine());
        double bananaInKg = Double.parseDouble(scan.nextLine());
        double orangeInKg = Double.parseDouble(scan.nextLine());
        double raspberryInKg = Double.parseDouble(scan.nextLine());
        double strawberryInKg = Double.parseDouble(scan.nextLine());

        double raspberryPrice = strawberryPrice/2;
        double orangePrice = raspberryPrice - raspberryPrice*0.4;
        double bananaPrice = raspberryPrice - raspberryPrice*0.8;

        double moneyNeeded = strawberryPrice*strawberryInKg + bananaPrice*bananaInKg + orangePrice*orangeInKg + raspberryPrice*raspberryInKg;
        System.out.printf("%.2f", moneyNeeded);
    }


}

package FirstStepsInCoding_Exercise;
import java.util.Scanner;

public class CharityCampaign_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countDays = Integer.parseInt(scan.nextLine());
        int countBakers = Integer.parseInt(scan.nextLine());
        int countCakes = Integer.parseInt(scan.nextLine());
        int countWaffles = Integer.parseInt(scan.nextLine());
        int countPancakes = Integer.parseInt(scan.nextLine());

        double sumPerBaker = (countCakes * 45.0) + (countWaffles * 5.80) + (countPancakes * 3.20);
        double allMoney = sumPerBaker * countBakers * countDays;
        double endProfit = allMoney - (allMoney/8.0);
        System.out.printf("%.2f", endProfit);

    }
}

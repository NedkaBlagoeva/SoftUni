package FirstStepsInCoding_Exercise;
import java.util.Scanner;

public class BirthdayParty_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hallPrice = Integer.parseInt(scan.nextLine());
        double cakePrice = hallPrice*0.2;
        double drinkPrice = cakePrice - (cakePrice*0.45);
        double animatorPrice = hallPrice/3;

        double budget = hallPrice + cakePrice + drinkPrice + animatorPrice;
        System.out.println(budget);
}
}

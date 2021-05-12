package ConditionalStatementsAdvanced_Exercise;

import java.util.Scanner;

public class Cinema_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String projectionType = scan.nextLine();
        int row = Integer.parseInt(scan.nextLine());
        int columns = Integer.parseInt(scan.nextLine());

        int sits = row * columns;
        double price = 0.0;

        switch (projectionType){
            case "Premiere":
                price = 12.00;
                break;
            case "Normal":
                price = 7.50;
                break;
            case "Discount":
                price = 5.00;
                break;
        }
        System.out.printf("%.2f leva", price*sits);

    }
}

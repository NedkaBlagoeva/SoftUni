package WhileLoop_Lab;

import java.util.Scanner;

public class AccountBalance_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String amount = scan.nextLine();
        double sum = 0;
        while (!amount.equals("NoMoreMoney")) {
            double num = Double.parseDouble(amount);
            if (num > 0) {
                sum += num;
                System.out.printf("Increase: %.2f\n",num);
            } else {
                System.out.println("Invalid operation!");
                break;
            }
            amount = scan.nextLine();
        }
        System.out.printf("Total: %.2f",sum);
    }
}

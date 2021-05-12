package ConditionalStatementsAdvanced_Lab;

import java.util.Scanner;

public class NumberInRange_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double num = Double.parseDouble(scan.nextLine());

        if (num >= -100 && num <=100 && num != 0){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }


    }
}

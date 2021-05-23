package DataTypesAndVariables_Lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class _03_ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 1; i <= n; i++) {
            String input = scan.nextLine();
            BigDecimal number = new BigDecimal(input);
            sum = number.add(sum);

        }
        System.out.println(sum);
    }
}
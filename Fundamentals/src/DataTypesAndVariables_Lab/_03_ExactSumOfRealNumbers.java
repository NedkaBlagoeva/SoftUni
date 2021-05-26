package DataTypesAndVariables_Lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class _03_ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 1; i <= n; i++) {
            BigDecimal number = new BigDecimal(scan.nextLine());
            sum = number.add(sum);
        }
        System.out.println(sum);
    }
}

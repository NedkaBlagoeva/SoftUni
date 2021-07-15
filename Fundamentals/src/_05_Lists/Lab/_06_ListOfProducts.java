package _05_Lists.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _06_ListOfProducts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] products = new String[n];
        for (int i = 0; i < products.length; i++) {
            String product = scan.nextLine();
            products[i] = product;
        }
        Arrays.sort(products);
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + 1 + "." + products[i]);
        }
    }
}

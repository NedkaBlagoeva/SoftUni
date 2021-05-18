package DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _05_ConcatNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name1 = scan.nextLine();
        String name2 = scan.nextLine();
        String symbol = scan.nextLine();

        System.out.printf("%s%s%s", name1, symbol, name2);
    }
}

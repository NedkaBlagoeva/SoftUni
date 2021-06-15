package Methods_Exercise;

import java.util.Scanner;

public class _09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (!input.equals("END")) {
            System.out.println(printPalindromeCheck(input));
            input = scan.nextLine();
        }
    }

    private static boolean printPalindromeCheck(String input) {
        String inputBackwards = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            inputBackwards += input.charAt(i);
        }
        return input.compareTo(inputBackwards) == 0;
    }
}

package _04_Methods.Exercise;

import java.util.Scanner;

public class _03_CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char symbol1 = scan.nextLine().charAt(0);
        char symbol2 = scan.nextLine().charAt(0);

        printSymbolsInRange(symbol1, symbol2);
    }

    private static void printSymbolsInRange(char char1, char char2) {
        if (char1 > char2) {
            for (int i = char2 + 1; i < char1; i++) {
                System.out.print((char) i + " ");
            }
        } else {
            for (int i = char1 + 1; i < char2; i++) {
                System.out.print((char) i + " ");
            }
        }
    }
}

package _09_TextProcessing.Lab;

import java.util.Scanner;

public class _05_DigitsLettersOther {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        StringBuilder symbols = new StringBuilder();

        char[] textSymbols = text.toCharArray();
        for (char textSymbol : textSymbols) {
            if (Character.isLetter(textSymbol)) {
                letters.append(textSymbol);
            } else if (Character.isDigit(textSymbol)) {
                digits.append(textSymbol);
            } else {
                symbols.append(textSymbol);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(symbols);
    }
}

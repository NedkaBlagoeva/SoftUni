package _09_TextProcessing.Exercises;

import java.util.Scanner;

public class _08_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\s+");
        double sum = 0;
        double number = 0;
        for (String word : words) {
            char firstSymbol = word.charAt(0);
            char lastSymbol = word.charAt(word.length() - 1);
            number = Integer.parseInt(word.substring(1, word.length() - 1));
            if (firstSymbol >= 'A' && firstSymbol <= 'Z') {
                number /= (firstSymbol - 64);
            }
            if (firstSymbol >= 'a' && firstSymbol <= 'z') {
                number *= (firstSymbol - 96);
            }
            if (lastSymbol >= 'A' && lastSymbol <= 'Z') {
                number -= (lastSymbol - 64);
            }
            if (lastSymbol >= 'a' && lastSymbol <= 'z') {
                number += (lastSymbol - 96);
            }
            sum += number;
        }
        System.out.printf("%.2f", sum);
    }
}

package _09_TextProcessing.Exercises;

import java.util.Scanner;

public class _06_ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        StringBuilder finalText = new StringBuilder();
        finalText.append(text.charAt(0));
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(i - 1)) {
                finalText.append(text.charAt(i));
            }
        }
        System.out.println(finalText);
    }
}

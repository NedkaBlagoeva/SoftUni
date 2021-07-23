package _09_TextProcessing.Lab;

import java.util.Scanner;

public class _04_TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] banWords = scan.nextLine().split(", ");
        String text = scan.nextLine();
        for (String banWord : banWords) {
            text = text.replace(banWord, "*".repeat(banWord.length()));
        }
        System.out.println(text);
    }
}

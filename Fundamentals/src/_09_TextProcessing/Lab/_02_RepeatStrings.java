package _09_TextProcessing.Lab;

import java.util.Scanner;

public class _02_RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] words = input.split("\\s+");
        StringBuilder multipliedText = new StringBuilder();
        for (String word : words) {
            multipliedText.append(word.repeat(word.length()));
        }
        System.out.println(multipliedText);

    }
}

//for (int i = 0; i < words.length; i++) {
//        for (int j = 0; j < words[i].length(); j++) {
//        multipliedText.append(words[i]);
//        }
//        }

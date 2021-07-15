package _04_Methods.Lab;

import java.util.Scanner;

public class _07_RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        int repetitions = Integer.parseInt(scan.nextLine());

        String repeatedText = repeatString(text, repetitions);
        System.out.println(repeatedText);
    }

    private static String repeatString(String text, int repetitions) {
        String repeatedText = "";
        for (int i = 1; i <= repetitions ; i++) {
            repeatedText += text;
        }
        return repeatedText;
    }
}

package _09_TextProcessing.Lab;

import java.util.Scanner;

public class _03_Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String textToRemove = scan.nextLine();
        String text = scan.nextLine();
        while (text.contains(textToRemove)) {
            text = text.replace(textToRemove, "");
        }

        System.out.println(text);
    }
}

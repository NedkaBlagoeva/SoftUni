package _04_Methods.Exercise;

import java.util.Scanner;

public class _05_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        getMiddleChar(text);
    }

    private static void getMiddleChar(String text) {
        if (text.length() % 2 == 1) {
            int midIndex = text.length() / 2;
            System.out.println(text.charAt(midIndex));
        } else {
            int midIndex1 = text.length() / 2 - 1;
            int midIndex2 = text.length() / 2;
            System.out.printf("%c%c", text.charAt(midIndex1), text.charAt(midIndex2));
        }
    }
}

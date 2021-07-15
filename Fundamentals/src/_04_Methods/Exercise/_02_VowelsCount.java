package _04_Methods.Exercise;

import java.util.Scanner;

public class _02_VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        vowelCounter(text);
    }

    private static void vowelCounter(String text) {
        int count = 0;
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'a':
                case 'e':
                case 'u':
                case 'i':
                case 'o':
                    count++;
                    break;
            }
        }
        System.out.println(count);
    }
}

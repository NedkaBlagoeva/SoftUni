package _09_TextProcessing.MoreExercise;

import java.util.Scanner;

public class _02_AsciiSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char startChar = scan.nextLine().charAt(0);
        char endChar = scan.nextLine().charAt(0);
        String text = scan.nextLine();
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) > startChar && text.charAt(i) < endChar) {
                sum += text.charAt(i);
            }
        }
        System.out.println(sum);
    }
}

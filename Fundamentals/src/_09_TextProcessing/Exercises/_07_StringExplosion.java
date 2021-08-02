package _09_TextProcessing.Exercises;

import java.util.Scanner;

public class _07_StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scan.nextLine());
        int power = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '>') {
                power += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
            } else if (power != 0) {
                input.deleteCharAt(i);
                i--;
                power--;
            }
        }
        System.out.println(input);
    }
}

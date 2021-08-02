package _09_TextProcessing.MoreExercise;

import java.util.Scanner;

public class _01_ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String text = scan.nextLine();
            String name = text.substring(text.indexOf('@') + 1, text.indexOf('|'));
            int age = Integer.parseInt(text.substring(text.indexOf('#') + 1, text.indexOf('*')));
            System.out.printf("%s is %d years old.%n", name, age);
        }
    }
}

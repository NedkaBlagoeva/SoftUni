package _02_DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class _05_DecryptingMessages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        int numberOfLines = Integer.parseInt(scan.nextLine());
        String message = "";
        for (int i = 1; i <= numberOfLines; i++) {
            char symbol = scan.nextLine().charAt(0);
            message += (char) (symbol + key);
        }
        System.out.println(message);
    }
}

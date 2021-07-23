package _09_TextProcessing.Exercises;

import java.util.Scanner;

public class _01_ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] usernames = scan.nextLine().split(", ");
        for (String username : usernames) {
            if (isValid(username)) {
                System.out.println(username);
            }
        }
    }

    private static boolean isValid(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }
        for (char symbol : username.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                return false;
            }
        }
        return true;
    }
}

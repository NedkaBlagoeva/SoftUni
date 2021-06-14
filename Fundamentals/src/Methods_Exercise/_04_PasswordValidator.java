package Methods_Exercise;

import java.util.Scanner;

public class _04_PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        if (!isValidLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!isValidContent(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!isValidDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (isValidLength(password) && isValidContent(password) && isValidDigits(password)) {
            System.out.println("Password is valid");
        }
    }

    private static boolean isValidLength(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    private static boolean isValidContent(String password) {
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidDigits(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (Character.isDigit(symbol)) {
                count++;
            }
        }
        return count >= 2;
    }
}

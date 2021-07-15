package _01_BasicSyntaxConditionalStatementsAndLoops.Ex;

import java.util.Scanner;

public class _05_Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String userName = scan.nextLine();
        String password = "";

        for (int i = userName.length() - 1; i >= 0; i--) {
            password += userName.charAt(i);
        }
        // System.out.print(password);
        String input = scan.nextLine();
        int count = 0;
        boolean isCorrect = true;
        while (!input.equals(password)) {
            count++;
            if (count >= 4) {
                System.out.printf("User %s blocked!", userName);
                isCorrect = false;
                break;
            }
            System.out.println("Incorrect password. Try again.");
            input = scan.nextLine();
        }
        if (isCorrect) {
            System.out.printf("User %s logged in.", userName);
        }
    }
}

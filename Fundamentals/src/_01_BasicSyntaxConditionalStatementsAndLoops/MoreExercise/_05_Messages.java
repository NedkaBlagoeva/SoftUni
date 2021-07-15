package _01_BasicSyntaxConditionalStatementsAndLoops.MoreExercise;

import java.util.Scanner;

public class _05_Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commands = Integer.parseInt(scanner.nextLine());

        int currentNum = 0;
        int mainDigit = 0;
        int digitalLength = 0;
        int offset = 0;
        int letterIndex = 0;


        for (int i = 0; i < commands; i++) {
            currentNum = Integer.parseInt(scanner.nextLine());
            while (currentNum != 0) {
                mainDigit = currentNum % 10;
                currentNum /= 10;
                digitalLength++;
            }
            offset = (mainDigit - 2) * 3;
            if (mainDigit == 8 || mainDigit == 9) {
                offset += 1;
            }
            letterIndex = (offset + digitalLength - 1);
            char symbol = (char) (letterIndex + 97);
            if (digitalLength == 0) {
                System.out.print(" ");
            } else {
                System.out.print(symbol);
            }
            digitalLength = 0;
        }

    }
}
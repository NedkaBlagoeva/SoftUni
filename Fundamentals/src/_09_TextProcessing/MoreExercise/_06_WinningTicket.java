package _09_TextProcessing.MoreExercise;

import java.util.Scanner;

public class _06_WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] tickets = input.split("\\s*,\\s*");
        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String firstHalf = ticket.substring(0, 10);
                String secondHalf = ticket.substring(10);
                if (!maxSequence(firstHalf).equals(maxSequence(secondHalf))) {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                    continue;
                }
                if (maxSequence(firstHalf).length() < 6 || maxSequence(secondHalf).length() < 6){
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                    continue;
                }
                if (maxSequence(firstHalf).equals(maxSequence(secondHalf))) {
                    String winningSequence = maxSequence(firstHalf);
                    if (winningSequence.contains("$") || winningSequence.contains("@") || winningSequence.contains("#") || winningSequence.contains("^")) {
                        if (winningSequence.length() >= 6 && winningSequence.length() <= 9) {
                            System.out.printf("ticket \"%s\" - %d%c%n", ticket, winningSequence.length(), winningSequence.charAt(0));
                        } else if (winningSequence.length() == 10) {
                            System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", ticket, 10, winningSequence.charAt(0));
                        }
                    }
                }
            }
        }
    }

    public static String maxSequence(String word) {
        char[] symbols = word.toCharArray();
        int count = 1;
        int maxCount = 0;
        char maxSymbol = ' ';
        for (int i = 0; i < symbols.length - 1; i++) {
            if (symbols[i] == symbols[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            if (maxCount < count) {
                maxCount = count;
                maxSymbol = symbols[i];
            }
        }
        return String.valueOf(maxSymbol).repeat(maxCount);
    }
}

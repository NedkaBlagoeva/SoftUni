package _09_TextProcessing.Exercises;

import java.util.Scanner;

public class _04_CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        StringBuilder encryptedMassage = new StringBuilder();
        for (char letter : message.toCharArray()) {
            encryptedMassage.append((char) (letter + 3));
        }
        System.out.println(encryptedMassage);
    }
}

package _09_TextProcessing.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class _03_TreasureFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] key = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String codeMassage = scan.nextLine();
        StringBuilder decodedMassage = new StringBuilder();
        while (!"find".equals(codeMassage)) {
            int j = 0;
            for (int i = 0; i < codeMassage.length(); i++) {
                if (j == key.length) {
                    j -= key.length;
                }
                decodedMassage.append((char) (codeMassage.charAt(i) - key[j]));
                j++;
            }
            String treasureType = decodedMassage.substring(decodedMassage.indexOf("&") + 1, decodedMassage.lastIndexOf("&"));
            String coordinates = decodedMassage.substring(decodedMassage.indexOf("<") + 1, decodedMassage.lastIndexOf(">"));
            System.out.printf("Found %s at %s%n", treasureType, coordinates);
            decodedMassage.setLength(0);
            codeMassage = scan.nextLine();
        }
    }
}

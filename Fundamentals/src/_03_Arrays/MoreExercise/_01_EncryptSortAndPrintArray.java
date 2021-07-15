package _03_Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class _01_EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countStrings = Integer.parseInt(scan.nextLine());
        String[] inputs = new String[countStrings];

        for (int i = 0; i < countStrings; i++) {
            String input = scan.nextLine();
            inputs[i] = input;
        }
        int sum = 0;
        int[] sumArray = new int[countStrings];
        int count = 0;
        for (String input : inputs) {
            for (int i = 0; i < input.length(); i++) {
                switch (input.charAt(i)) {
                    case 'a': case 'A':
                    case 'e': case 'E':
                    case 'i': case 'I':
                    case 'o': case 'O':
                    case 'u': case 'U':
                        sum += (int) input.charAt(i) * input.length();
                        break;
                    default:
                        sum += (int) input.charAt(i) / input.length();
                        break;
                }
            }
            sumArray[count] = sum;
            sum = 0;
            count++;
        }
        Arrays.sort(sumArray);
        for (int numbersFromWords : sumArray) {
            System.out.println(numbersFromWords);
        }
    }
}

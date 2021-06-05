package Array_Exercise;

import java.util.Scanner;

public class _03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        String[] array1 = new String[lines];
        String[] array2 = new String[lines];

        for (int i = 0; i < lines; i++) {
            String[] input = scan.nextLine().split(" ");
            String number1 = input[0];
            String number2 = input[1];

            if ((i + 1) % 2 == 0) {
                array1[i] = number2;
                array2[i] = number1;
            } else {
                array1[i] = number1;
                array2[i] = number2;
            }
        }
        for (String s : array1) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : array2) {
            System.out.print(s + " ");
        }
    }
}

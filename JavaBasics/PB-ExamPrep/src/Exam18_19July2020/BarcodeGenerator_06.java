package Exam18_19July2020;

import java.util.Scanner;

public class BarcodeGenerator_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rangeIn = Integer.parseInt(scan.nextLine());
        int rangeOut = Integer.parseInt(scan.nextLine());
        int digit1 = 0;
        int digit2 = 0;
        int digit3 = 0;
        int digit4 = 0;
        int count = 0;
        int num = 0;

        for (int i = rangeIn; i <= rangeOut; i++) {
            num = i;

            while (num > 0) {
                count = 0;
                digit4 = num % 10;
                if (digit4 % 2 != 0) {
                    count++;
                }
                num = num / 10;
                digit3 = num % 10;
                if (digit3 % 2 != 0) {
                    count++;
                }
                num = num / 10;
                digit2 = num % 10;
                if (digit2 % 2 != 0) {
                    count++;
                }
                num = num / 10;
                digit1 = num % 10;
                if (digit1 % 2 != 0) {
                    count++;
                }
                num = num / 10;
                if (count == 4) {
                    System.out.print(i + " ");
                }

            }

        }
    }

}

package Exam18_19July2020;

import java.util.Scanner;

public class BarcodeGenerator2_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rangeIn = Integer.parseInt(scan.nextLine());
        int rangeOut = Integer.parseInt(scan.nextLine());

        int firstDigitIn = (rangeIn / 1000) % 10;
        int secondDigitIn = (rangeIn / 100) % 10;
        int thirdDigitIn = (rangeIn / 10) % 10;
        int fourthDigitIn = rangeIn % 10;

        int firstDigitOut = (rangeOut / 1000) % 10;
        int secondDigitOut = (rangeOut / 100) % 10;
        int thirdDigitOut = (rangeOut / 10) % 10;
        int fourthDigitOut = rangeOut % 10;


        for (int i = firstDigitIn; i <= firstDigitOut; i++) {
            for (int j = secondDigitIn; j <= secondDigitOut; j++) {
                for (int k = thirdDigitIn; k <= thirdDigitOut; k++) {
                    for (int l = fourthDigitIn; l <= fourthDigitOut; l++) {
                        if (i%2 != 0 && j%2 != 0 && k%2 != 0 && l%2 != 0) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }
                }
            }
        }


    }
}

package _02_DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class _02_FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            String lineOfNumbers = scan.nextLine();
            String[] parts = lineOfNumbers.split(" ");
            long number1 = Long.parseLong(parts[0]);
            long number2 = Long.parseLong(parts[1]);

            if (number1 > number2) {
                while (number1 != 0) {
                    sum += Math.abs(number1 % 10);
                    number1 /= 10;
                }
            } else {
                while (number2 != 0) {
                    sum += Math.abs(number2 % 10);
                    number2 /= 10;
                }
            }
            System.out.println(sum);
            sum = 0;
        }
    }
}

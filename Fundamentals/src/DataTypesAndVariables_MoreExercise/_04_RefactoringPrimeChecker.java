package DataTypesAndVariables_MoreExercise;

import java.util.Scanner;

public class _04_RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int endRange = Integer.parseInt(scanner.nextLine());
        for (int number = 2; number <= endRange; number++) {
            boolean isPrime = true;
            for (int divider = 2; divider < number; divider++) {
                if (number % divider == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", number, isPrime);
        }

    }
}

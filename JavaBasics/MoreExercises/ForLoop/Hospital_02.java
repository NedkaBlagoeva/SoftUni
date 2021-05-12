package MoreExercises.ForLoop;

import java.util.Scanner;

public class Hospital_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int medics = 7;
        int treated = 0;
        int untreated = 0;
        for (int i = 1; i <= n; i++) {
            int patients = Integer.parseInt(scan.nextLine());
            if (i % 3 == 0) {
                if (untreated > treated) {
                    medics++;
                }
            }
            if (medics>=patients) {
                treated += patients;
            } else {
                treated += medics;
                untreated += patients - medics;
            }

        }
        System.out.printf("Treated patients: %d.\n", treated);
        System.out.printf("Untreated patients: %d.", untreated);
    }
}

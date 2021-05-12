package Exam28_29March2020;

import java.util.Scanner;

public class TrekkingMania_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int groupsNumber = Integer.parseInt(scan.nextLine());
        int musala = 0;
        int monblan = 0;
        int kilimandjaro = 0;
        int k2 = 0;
        int everest = 0;
        int all = 0;

        for (int i = 1; i <= groupsNumber; i++) {
            int people = Integer.parseInt(scan.nextLine());
            all +=people;
            if (people <= 5) {
                musala += people;
            } else if (people <= 12) {
                monblan += people;
            } else if (people <= 25) {
                kilimandjaro += people;
            } else if (people <= 40) {
                k2 += people;
            } else {
                everest += people;
            }

        }
        System.out.printf("%.2f%%\n", musala * 1.0 / all * 100);
        System.out.printf("%.2f%%\n", monblan * 1.0 / all * 100);
        System.out.printf("%.2f%%\n", kilimandjaro * 1.0 / all * 100);
        System.out.printf("%.2f%%\n", k2 * 1.0 / all * 100);
        System.out.printf("%.2f%%", everest * 1.0 / all * 100);
    }
}

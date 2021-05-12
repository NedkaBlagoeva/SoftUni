package MoreExercises.ForLoop;

import java.util.Scanner;

public class FootballLeague_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int stadiumVolume = Integer.parseInt(scan.nextLine());
        int fens = Integer.parseInt(scan.nextLine());
        double countA = 0;
        double countB = 0;
        double countV = 0;
        double countG = 0;

        for (int i = 1; i <= fens; i++) {
            String sector = scan.nextLine();

            switch (sector) {
                case "A":
                    countA++;
                    break;
                case "B":
                    countB++;
                    break;
                case "V":
                    countV++;
                    break;
                case "G":
                    countG++;
                    break;
            }
        }
        System.out.printf("%.2f%%\n", countA / fens * 100);
        System.out.printf("%.2f%%\n", countB / fens * 100);
        System.out.printf("%.2f%%\n", countV / fens * 100);
        System.out.printf("%.2f%%\n", countG / fens * 100);
        System.out.printf("%.2f%%", fens * 1.0 / stadiumVolume * 100);
    }
}
//        1.	Процентът на феновете в сектор А
//        2.	Процентът на феновете в сектор Б
//        3.	Процентът на феновете в сектор В
//        4.	Процентът на феновете в сектор Г
//        5.	Процентът на всички фенове, спрямо капацитета на стадиона.

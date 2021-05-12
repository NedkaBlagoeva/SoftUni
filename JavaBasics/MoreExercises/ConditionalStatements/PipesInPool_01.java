package MoreExercises.ConditionalStatements;

import java.util.Scanner;

public class PipesInPool_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int v = Integer.parseInt(scan.nextLine());
        int p1 = Integer.parseInt(scan.nextLine());
        int p2 = Integer.parseInt(scan.nextLine());
        double hours = Double.parseDouble(scan.nextLine());

        double vAllPipes = p1 * hours + p2 * hours;
        double percentFull = vAllPipes / v * 100;
        double percentP1 = p1 * hours / vAllPipes * 100;
        double percentP2 = p2 * hours / vAllPipes * 100;

        if (v >= vAllPipes) {
            System.out.printf("The pool is %.2f%% full.Pipe 1: %.2f%%. Pipe 2: %.2f%%.", percentFull,percentP1,percentP2);
        }else{
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.",hours, Math.abs(v-vAllPipes));
        }

    }
}

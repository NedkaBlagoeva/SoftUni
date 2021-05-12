package MoreExercises.ConditionalStatementsAdvanced;

import java.util.Scanner;

public class MultiplyBy2_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num ;
                do {
                    num = Double.parseDouble(scan.nextLine());
                    if (num >= 0) {
                        num*=2;
                        System.out.printf("Result: %.2f%n", num);
                    } else {
                        System.out.println("Negative number!");
                    }

                } while (num >= 0);

            }
        }


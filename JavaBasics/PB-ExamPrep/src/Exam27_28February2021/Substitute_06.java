package Exam27_28February2021;

import java.util.Scanner;

public class Substitute_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int k = Integer.parseInt(scan.nextLine());
        int l = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        int changes = 0;

        for (int i = k; i <= 8; i++) {
            for (int j = 9; j >= l; j--) {
                for (int o = m; o <= 8; o++) {
                    for (int p = 9; p >= n; p--) {
                        if (changes >= 6){
                            break;
                        }
                        if (i % 2 == 0 && o % 2 == 0 && j % 2 == 1 && p % 2 == 1) {
                            if (i == o && j == p) {
                                System.out.println("Cannot change the same player.");
                            } else {
                                changes ++;
                                System.out.printf("%d%d - %d%d\n", i, j, o, p);
                            }


                        }
                    }
                }
            }
        }
    }
}

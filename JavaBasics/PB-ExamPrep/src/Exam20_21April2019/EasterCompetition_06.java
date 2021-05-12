package Exam20_21April2019;

import java.util.Scanner;

public class EasterCompetition_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countOfSweetBread = Integer.parseInt(scan.nextLine());
        int score = 0;
        int maxScore = 0;
        String bestBaker = "";

        for (int i = 1; i <= countOfSweetBread ; i++) {
            String baker = scan.nextLine();
            String input = scan.nextLine();
            while (!input.equals("Stop")){
              int  points = Integer.parseInt(input);
                score += points;
                input = scan.nextLine();
            }
            System.out.printf("%s has %d points.\n", baker, score); // Chef Manchev has 40 points.
            if (score > maxScore){
                maxScore = score;
                bestBaker = baker;
                System.out.printf("%s is the new number 1!\n", baker);
            }
           score = 0;
        }
        System.out.printf("%s won competition with %d points!", bestBaker, maxScore);
    }
}

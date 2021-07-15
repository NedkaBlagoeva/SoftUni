package _07_MidExam._03_FundamentalsMidExamRetake;

import java.util.Scanner;

public class _01_CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int energy = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int wins = 0;
        while (!"End of battle".equals(input)){
            int distance = Integer.parseInt(input);
            if (energy >= distance){
                energy -= distance;
                wins++;
                if (wins % 3 == 0){
                    energy +=wins;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d" +
                        " won battles and %d energy", wins, energy);
                return;
            }
            input = scan.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d", wins, energy);
    }
}

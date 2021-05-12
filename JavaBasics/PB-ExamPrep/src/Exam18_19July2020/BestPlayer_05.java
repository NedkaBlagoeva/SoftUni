package Exam18_19July2020;

import java.util.Scanner;

public class BestPlayer_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String player = scan.nextLine();
        int maxGoals = 0;
        String bestPlayer = "";

        while (!player.equals("END")) {
            int goals = Integer.parseInt(scan.nextLine());
            if (goals > maxGoals) {
                maxGoals = goals;
                bestPlayer = player;
            }
            if (maxGoals >= 10) {
                break;
            }
            player = scan.nextLine();
        }
        System.out.printf("%s is the best player!\n", bestPlayer);
        if (maxGoals < 3) {
            System.out.printf("He has scored %d goals.", maxGoals);
        } else if (maxGoals >= 3 ) {
            System.out.printf("He has scored %s goals and made a hat-trick !!!", maxGoals);
        }
    }
}

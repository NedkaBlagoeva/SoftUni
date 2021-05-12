package Exam28_29March2020;

import java.util.Scanner;

public class TournamentOfChristmas_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        double money = 0.0;
        int countDayWin = 0;
        int countDayLose = 0;
        int dayWinner = 0;
        int dayLoser = 0;
        double allMoney = 0.0;

        for (int i = 1; i <= days; i++) {
            String sport = scan.nextLine();
            while (!sport.equals("Finish")) {
                String result = scan.nextLine();
                switch (result) {
                    case "win":
                        countDayWin++;
                        money += 20;
                        break;
                    case "lose":
                        countDayLose++;
                        break;
                }

                sport = scan.nextLine();
            }
            if (countDayWin > countDayLose) {
                dayWinner++;
                money *= 1.10;
            } else if (countDayWin < countDayLose) {
                dayLoser++;
            }
            countDayWin = 0;
            countDayLose = 0;
            allMoney += money;
            money=0;
        }
        if (dayWinner > dayLoser) {
            allMoney *= 1.20;
            System.out.printf("You won the tournament! Total raised money: %.2f", allMoney);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", allMoney);
        }


    }
}

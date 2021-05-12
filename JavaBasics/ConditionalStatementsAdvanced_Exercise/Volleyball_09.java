package ConditionalStatementsAdvanced_Exercise;

import java.util.Scanner;

public class Volleyball_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String yearType = scan.nextLine();
        int holidays = Integer.parseInt(scan.nextLine());
        int weekendsHome = Integer.parseInt(scan.nextLine());


        double weekendSofia = 48 - weekendsHome;
        double gamesSofiq = weekendSofia*3.0/4;
        double gamesHolidays = holidays*2.0/3;
        double allGames = gamesHolidays + gamesSofiq + weekendsHome;

        switch (yearType){
            case "leap":
                allGames *= 1.15;
                break;

        }System.out.printf("%.0f",Math.floor(allGames));
    }
}

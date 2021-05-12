package ConditionalStatementsAdvanced_Exercise;

import java.util.Scanner;

public class OnTimeForExam_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        •	Първият ред съдържа час на изпита – цяло число от 0 до 23.
//•	Вторият ред съдържа минута на изпита – цяло число от 0 до 59.
//•	Третият ред съдържа час на пристигане – цяло число от 0 до 23.
//•	Четвъртият ред съдържа минута на пристигане – цяло число от 0 до 59.
        int examHour = Integer.parseInt(scan.nextLine());
        int examMinutes = Integer.parseInt(scan.nextLine());
        int arriveHour = Integer.parseInt(scan.nextLine());
        int arriveMinutes = Integer.parseInt(scan.nextLine());
        int allMinutesExam = examHour * 60 + examMinutes;
        int allMinutesArrive = arriveHour * 60 + arriveMinutes;

        int diff = allMinutesExam - allMinutesArrive;

        if (diff == 0) {
            System.out.println("On time");
        } else if (diff < 0) {
            if (Math.abs(diff) < 60) {
                System.out.printf("Late%n%d minutes after the start", Math.abs(diff));
            } else {
                int hour = diff / 60;
                int minutes = diff % 60;
                System.out.printf("Late%n%d:%02d hours after the start", Math.abs(hour), Math.abs(minutes));
            }
        } else if (diff <= 30) {
            System.out.printf("On time%n%d minutes before the start", diff);
        } else {
            if (diff < 60) {
                System.out.printf("Early%n%d minutes before the start", diff);
            } else {
                int hour = diff / 60;
                int minutes = diff % 60;
                System.out.printf("Early%n%d:%02d hours before the start", hour, minutes);
            }
        }
    }
}

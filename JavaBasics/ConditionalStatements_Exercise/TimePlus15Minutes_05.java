package ConditionalStatements_Exercise;

import java.util.Scanner;

public class TimePlus15Minutes_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hour = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        int totalMinutes = hour * 60 + minutes + 15;
        int newHour = totalMinutes / 60;
        int newMin = totalMinutes % 60;

        if (newHour>23){
            newHour = 0;
        }
        System.out.printf("%d:%02d", newHour, newMin);

    }
}

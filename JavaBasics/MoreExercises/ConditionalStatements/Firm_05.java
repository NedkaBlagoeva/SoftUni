package MoreExercises.ConditionalStatements;
import java.util.Scanner;

public class Firm_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hoursNeeded = Integer.parseInt(scan.nextLine());
        int daysToFinish = Integer.parseInt(scan.nextLine());
        int workersOvertime = Integer.parseInt(scan.nextLine());

        double regularHours = daysToFinish *0.9 * 8;
        double overtimeHours = workersOvertime * 2 *daysToFinish;
        double totalHours = regularHours + overtimeHours;
        double hoursLeft = Math.abs(totalHours-hoursNeeded);

        if (totalHours>=hoursNeeded){
            System.out.printf("Yes!%.0f hours left.",Math.floor(hoursLeft));
        }else {
            System.out.printf("Not enough time!%.0f hours needed.", Math.ceil(hoursLeft));

        }
    }
}

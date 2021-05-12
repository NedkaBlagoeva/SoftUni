package FirstStepsInCoding_Exercise;
import java.util.Scanner;

public class VacationBooksList_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countPages = Integer.parseInt(scan.nextLine());
        int pagesPerDay = Integer.parseInt(scan.nextLine());
        int countDays = Integer.parseInt(scan.nextLine());

        double hoursPerDay = (countPages/pagesPerDay)/countDays;
        System.out.println(hoursPerDay);

    }
}

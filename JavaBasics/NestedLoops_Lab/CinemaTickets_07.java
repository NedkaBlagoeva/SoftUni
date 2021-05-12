package NestedLoops_Lab;

import java.util.Scanner;

public class CinemaTickets_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countStudent = 0;
        int countStandard = 0;
        int countKid = 0;
        int countAll = 0;


        while (true) {
            String movieName = scan.nextLine();
            if (movieName.equals("Finish")) {
                break;
            }
            int freeSeats = Integer.parseInt(scan.nextLine());
            int capacity = freeSeats;
            int countForOneMovie = 0;

            while (freeSeats > 0) {
                String type = scan.nextLine();
                if (type.equals("End")) {
                    break;
                }
                countAll++;
                switch (type) {
                    case "student":
                        countStudent++;
                        break;
                    case "standard":
                        countStandard++;
                        break;
                    case "kid":
                        countKid++;
                        break;
                }
                freeSeats--;
                countForOneMovie++;
            }
            System.out.printf("%s - %.2f%% full.\n", movieName, countForOneMovie * 1.0 / capacity * 100);
        }
        System.out.printf("Total tickets: %d\n", countAll);
        System.out.printf("%.2f%% student tickets.\n", countStudent * 1.0 / countAll * 100);
        System.out.printf("%.2f%% standard tickets.\n", countStandard * 1.0 / countAll * 100);
        System.out.printf("%.2f%% kids tickets.\n", countKid * 1.0 / countAll * 100);

    }
}

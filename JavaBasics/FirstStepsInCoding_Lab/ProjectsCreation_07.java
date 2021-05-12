package FirstStepsInCoding_Lab;

import java.util.Scanner;

public class ProjectsCreation_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String archName = scan.nextLine();
        int countProjects = Integer.parseInt(scan.nextLine());
        int hoursToFinish = countProjects * 3;

        System.out.println("The architect " +archName +" will need " + hoursToFinish +" hours to complete " + countProjects + " project/s.");

    }
}

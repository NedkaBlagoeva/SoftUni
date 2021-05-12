package WhileLoop_Exercise;

import java.util.Scanner;

public class ExamPreparation_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int timesToFail = Integer.parseInt(scan.nextLine());
        int badGrades = 0;
        double allGrades = 0;
        int taskCount = 0;
        boolean isFail = true;
        String lastTask = "";

        while (badGrades <= timesToFail) {
            String task = scan.nextLine();
            if (task.equals("Enough")) {
                isFail = false;
                break;
            }
            taskCount++;
            lastTask = task;
            int grade = Integer.parseInt(scan.nextLine());
            allGrades += grade;
            if (grade <= 4) {
                badGrades++;
            }
        }
        if (isFail){
            System.out.printf("You need a break, %d poor grades.", badGrades);
        }else{
            System.out.printf("Average score: %.2f\n" +
                    "Number of problems: %d\n" +
                    "Last problem: %s\n", allGrades/taskCount, taskCount, lastTask);
        }
    }
}

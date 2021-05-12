package Exam15_16June2019;

import java.util.Scanner;

public class Oscars_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String actor = scan.nextLine();
        double startPoints = Double.parseDouble(scan.nextLine());
        int judges = Integer.parseInt(scan.nextLine());
        double actorPoints = startPoints;
        boolean isNominee = false;

        for (int i = 1; i <= judges; i++) {
            String judgeName = scan.nextLine();
            double points = Double.parseDouble(scan.nextLine());

            actorPoints += (judgeName.length() * points / 2);
            if (actorPoints > 1250.5){
                isNominee = true;
                break;
            }
        }
            if (isNominee){
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actor, actorPoints);
            }else{
                System.out.printf("Sorry, %s you need %.1f more!", actor, 1250.5 - actorPoints);
            }
    }
}

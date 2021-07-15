package _01_BasicSyntaxConditionalStatementsAndLoops.Ex;

import java.util.Scanner;

public class _09_PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double ivanChoMoney = Double.parseDouble(scan.nextLine());
        int studentsCount = Integer.parseInt(scan.nextLine());
        double lightsabrePrice = Double.parseDouble(scan.nextLine());
        double robePrice = Double.parseDouble(scan.nextLine());
        double beltPrice = Double.parseDouble(scan.nextLine());
        double sum = 0.0;

        double moneyForLightsabres = Math.ceil(studentsCount * 1.1) * lightsabrePrice;
        double moneyForRobes = studentsCount * robePrice;
        double moneyForBelts = (studentsCount * beltPrice) - (studentsCount / 6) * beltPrice;
        sum = moneyForLightsabres + moneyForRobes + moneyForBelts;

        if (ivanChoMoney >= sum) {
            System.out.printf("The money is enough - it would cost %.2flv.", sum);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", sum - ivanChoMoney);
        }


    }
}

package FirstStepsInCoding_Exercise;
import java.util.Scanner;

public class DepositCalculator_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double deposit = Double.parseDouble(scan.nextLine());
        int months = Integer.parseInt(scan.nextLine());
        double interestRate = (Double.parseDouble(scan.nextLine()))/100;
        double endSum = deposit + months *((deposit*interestRate)/12);
        System.out.println(endSum);

    }
}

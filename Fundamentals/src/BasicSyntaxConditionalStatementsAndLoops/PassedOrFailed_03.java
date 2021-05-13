package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class PassedOrFailed_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double input = Double.parseDouble(scan.nextLine());

        if (input >= 3){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }
    }
}

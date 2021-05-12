package ConditionalStatements_Lab;
import java.util.Scanner;

public class EvenOrOdd_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());

        if (a%2==0){
            System.out.println("even");
        }else{
            System.out.println("odd");
        }
    }
}

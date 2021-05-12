package WhileLoop_Lab;

import java.util.Scanner;

public class SumNumbers_03{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstNum = Integer.parseInt(scan.nextLine());
        int sum = 0;

        while (firstNum > sum){
           int num = Integer.parseInt(scan.nextLine());
            sum += num;
        }
        System.out.println(sum);
    }
}

package WhileLoop_Lab;

import java.util.Scanner;

public class MinNumber_07 {
           public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String num = scan.nextLine();
            int minNum = Integer.MAX_VALUE;

            while (!num.equals("Stop")){
                int currentNum = Integer.parseInt(num);
                if (currentNum < minNum){
                    minNum = currentNum;
                }num = scan.nextLine();
            }
            System.out.println(minNum);
        }
    }



package WhileLoop_Lab;

import java.util.Scanner;

public class ReadText_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (!input.equals("Stop")){
            System.out.println(input);
            input = scan.nextLine();

        }
    }
}

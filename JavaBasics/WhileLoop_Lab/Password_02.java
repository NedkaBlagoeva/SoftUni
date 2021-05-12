package WhileLoop_Lab;

import java.util.Scanner;

public class Password_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        String password = scan.nextLine();
        String input = scan.nextLine();

        while (!password.equals(input)){
            input = scan.nextLine();
        }
        System.out.printf("Welcome %s!", name);
    }
}

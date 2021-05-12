package WhileLoop_Lab;

import java.util.Scanner;

public class Sequence_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int nextNum = 1;
        while (nextNum <= n) {
            System.out.println(nextNum);
            nextNum = 2 * nextNum + 1;
        }
    }
}

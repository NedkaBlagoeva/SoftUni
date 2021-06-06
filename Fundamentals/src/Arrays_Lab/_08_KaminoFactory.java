package Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _08_KaminoFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();

        while (input.equals("Clone them!")){
            int [] sequence = Arrays.stream(input.split("!")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < sequence.length; i++) {

            }



            input = scan.nextLine();
        }
    }
}

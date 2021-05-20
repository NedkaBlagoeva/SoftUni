package DataTypesAndVariables_Lab;

import java.util.Scanner;

public class _06_CharsToString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        String a = scan.next();
//        String b = scan.nextLine();
//        String c = scan.nextLine();
//        String string = a + b + c;
//        System.out.println(string);

        char q = scan.next().charAt(0);
        char w = scan.next().charAt(0);
        char e = scan.next().charAt(0);

        String fun = String.format("%s%s%s", q, w, e);
        System.out.println(fun);
    }
}

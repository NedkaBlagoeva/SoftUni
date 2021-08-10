package _FinalExam._04_FinalExam;

import java.util.Scanner;

public class _01_PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        String commands = scan.nextLine();
        while (!"Done".equals(commands)) {
            String command = commands.split("\\s+")[0];
            switch (command) {
                case "TakeOdd":
                    StringBuilder oddOnly = new StringBuilder();
                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 != 0) {
                            oddOnly.append(password.charAt(i));
                        }
                    }
                    password = oddOnly.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commands.split("\\s+")[1]);
                    int length = Integer.parseInt(commands.split("\\s+")[2]);
                    StringBuilder cut = new StringBuilder(password);
                    cut.delete(index, index + length);
                    password = cut.toString();
                    System.out.println(password);
                    break;
                case "Substitute":
                    String oldString = commands.split("\\s+")[1];
                    String newString = commands.split("\\s+")[2];
                    if (password.contains(oldString)) {
                        password = password.replaceAll(oldString, newString);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
                default:
                    break;
            }
            commands = scan.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }
}

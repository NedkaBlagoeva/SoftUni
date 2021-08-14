package FinalExam.Mine_14_08_21;

import java.util.Scanner;

public class _01_Problem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String email = scan.nextLine();
        String commands = scan.nextLine();
        while (!"Complete".equals(commands)) {
            String[] commandsParts = commands.split("\\s+");
            String command = commandsParts[0];
            switch (command) {
                case "Make":
                    String secondWord = commandsParts[1];
                    if (secondWord.equals("Upper")) {
                        email = email.toUpperCase();
                        System.out.println(email);
                    } else if (secondWord.equals("Lower")) {
                        email = email.toLowerCase();
                        System.out.println(email);
                    }
                    break;
                case "GetDomain":
                    int count = Integer.parseInt(commandsParts[1]);
                    System.out.println(email.substring(email.length() - count));
                    break;
                case "GetUsername":
                    if (email.contains("@")) {
                        System.out.println(email.substring(0, email.indexOf("@")));
                    } else {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", email);
                    }
                    break;
                case "Replace":
                    String symbol = commandsParts[1];
                    email = email.replace(symbol, "-");
                    System.out.println(email);
                    break;
                case "Encrypt":
                    char[] emailSymbols = email.toCharArray();
                    for (char emailSymbol : emailSymbols) {
                        System.out.print((int) emailSymbol + " ");
                    }
                    break;
                default:
                    break;
            }
            commands = scan.nextLine();
        }
    }
}

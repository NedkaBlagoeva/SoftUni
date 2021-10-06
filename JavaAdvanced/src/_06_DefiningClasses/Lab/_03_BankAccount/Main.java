package _06_DefiningClasses.Lab._03_BankAccount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, BankAccount> bankAccounts = new HashMap<>();
        String input = scan.nextLine();

        while (!input.equals("End")) {
            String output = null;
            String[] commands = input.split("\\s+");
            String command = commands[0];
            switch (command) {
                case "Create":
                    BankAccount account = new BankAccount();
                    bankAccounts.put(account.getId(), account);
                    output = "Account ID" + account.getId() + " created";
                    break;
                case "Deposit":
                    int id = Integer.parseInt(commands[1]);
                    int amount = Integer.parseInt(commands[2]);
                    if (bankAccounts.containsKey(id)) {
                        bankAccounts.get(id).deposit(amount);
                        output = String.format("Deposited %d to ID%d", amount, id);
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(commands[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int id1 = Integer.parseInt(commands[1]);
                    int years = Integer.parseInt(commands[2]);
                    if (bankAccounts.containsKey(id1)) {
                        double interest1 = bankAccounts.get(id1).getInterest(years);
                        output = String.format("%.2f", interest1);
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                default:
                    break;
            }
            if (output != null) {
                System.out.println(output);
            }
            input = scan.nextLine();
        }
    }
}

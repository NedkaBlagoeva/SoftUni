package _05_FundamentalsMidExam;

import java.util.Scanner;

public class _02_MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] rooms = scan.nextLine().split("\\|");
        int health = 100;
        int bitcoin = 0;
        for (int i = 0; i < rooms.length; i++) {
            String room = rooms[i];
            String[] commands = room.split("\\s+");
            String command = commands[0];
            int commandValue = Integer.parseInt(commands[1]);
            switch (command) {
                case "potion":
                    health += commandValue;
                    if (health > 100) {
                        int amount = Math.abs(health - 100 - commandValue);
                        health = 100;
                        System.out.printf("You healed for %d hp.%n", amount);
                    } else {
                        System.out.printf("You healed for %d hp.%n", commandValue);
                    }
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    bitcoin += commandValue;
                    System.out.printf("You found %d bitcoins.%n", commandValue);
                    break;
                default:
                    //monster
                    health -= commandValue;
                    if (health <= 0) {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d", i + 1);
                        return;
                    } else {
                        System.out.printf("You slayed %s.%n", command);
                    }
                    break;
            }
        }
        System.out.printf("You've made it!%n" +
                "Bitcoins: %d%n" +
                "Health: %d", bitcoin, health);
    }
}
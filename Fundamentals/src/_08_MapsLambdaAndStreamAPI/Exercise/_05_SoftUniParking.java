package _08_MapsLambdaAndStreamAPI.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, String> users = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String command = input[0];
            String name = input[1];

            switch (command) {
                case "register":
                    String licencePlate = input[2];
                    if (users.containsKey(name)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", users.get(name));
                    } else {
                        users.put(name, licencePlate);
                        System.out.printf("%s registered %s successfully%n", name, licencePlate);
                    }
                    break;
                case "unregister":
                    if (!users.containsKey(name)) {
                        System.out.printf("ERROR: user %s not found%n", name);
                    } else {
                        users.remove(name);
                        System.out.printf("%s unregistered successfully%n", name);
                    }
                    break;
                default:
                    break;
            }
        }
        users.entrySet().forEach(e -> System.out.printf("%s => %s%n", e.getKey(), e.getValue()));
    }
}

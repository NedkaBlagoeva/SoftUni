package _08_MapsLambdaAndStreamAPI.Exercise;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _02_AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> resourcesCount = new LinkedHashMap<>();
        String resource = scan.nextLine();
        while (!"stop".equals(resource)) {
            int quantity = Integer.parseInt(scan.nextLine());
            resourcesCount.putIfAbsent(resource, 0);
            resourcesCount.put(resource, resourcesCount.get(resource) + quantity);

            resource = scan.nextLine();
        }
        resourcesCount.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}

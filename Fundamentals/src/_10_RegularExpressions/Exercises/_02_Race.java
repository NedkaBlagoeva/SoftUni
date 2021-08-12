package _10_RegularExpressions.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class _02_Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] racers = scan.nextLine().split(", ");
        Map<String, Integer> racersAndKm = new LinkedHashMap<>();
        for (String racer : racers) {
            racersAndKm.put(racer, 0);
        }
        String racersInfo = scan.nextLine();
        while (!"end of race".equals(racersInfo)) {
            StringBuilder racerName = new StringBuilder("");
            int km = 0;
            for (int i = 0; i < racersInfo.length(); i++) {
                if (Character.isLetter(racersInfo.charAt(i))) {
                   racerName.append(racersInfo.charAt(i));
                } else if (Character.isDigit(racersInfo.charAt(i))) {
                    km += Character.getNumericValue(racersInfo.charAt(i));
                }
            }
            if (racersAndKm.containsKey(racerName.toString())) {
                int newKm = racersAndKm.get(racerName.toString()) + km;
                racersAndKm.put(racerName.toString(), newKm);
            }
            racersInfo = scan.nextLine();
        }
        List <String> winners = new ArrayList<>();
        racersAndKm
                .entrySet()
                .stream()
                .sorted((d1, d2) -> Integer.compare(d2.getValue(), d1.getValue()))
                .limit(3).forEach(racer -> winners.add(racer.getKey()));
        System.out.printf("1st place: %s\n" +
                "2nd place: %s\n" +
                "3rd place: %s", winners.get(0), winners.get(1), winners.get(2));
    }
}

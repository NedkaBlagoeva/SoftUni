package ObjectsAndClasses_Exercise.AdvertisementMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> phrases = Arrays.asList("Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product.");
        List<String> events = Arrays.asList("Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!");
        List<String> authors = Arrays.asList("Diana", "Petya", "Stella",
                "Elena", "Katya", "Iva", "Annie", "Eva");
        List<String> cities = Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse");

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            int ph = new Random().nextInt(phrases.size());
            String phase = phrases.get(ph);
            int e = new Random().nextInt(events.size());
            String event = events.get(e);
            int a = new Random().nextInt(authors.size());
            String author = authors.get(a);
            int c = new Random().nextInt(cities.size());
            String city = cities.get(c);

            AdvertisementMessage newMessage = new AdvertisementMessage(phase, event, author, city);
            System.out.println(newMessage);
        }
    }
}

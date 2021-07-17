package _08_MapsLambdaAndStreamAPI.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04_WordFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = Arrays.stream(scan.nextLine()
                .split(" "))
                .filter(w -> w.length() % 2 == 0).toArray(String[]::new);
        Arrays.stream(words).forEach(System.out::println);
    }
}

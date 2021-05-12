package Exam15_16June2019;

import java.util.Scanner;

public class FavoriteMovie_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        int countMovies = 0;

        String movie = scan.nextLine();
        int maxPoints = Integer.MIN_VALUE;
        String bestMovie = "";

        while (!movie.equals("STOP")) {
            countMovies++;
            for (int i = 0; i < movie.length(); i++) {
                sum += movie.charAt(i);
                if (movie.charAt(i) >= 'A' && movie.charAt(i) <= 'Z') {
                    sum -= movie.length();
                } else if (movie.charAt(i) >= 'a' && movie.charAt(i) <= 'z') {
                    sum -= 2 * movie.length();
                }
            }
            if (sum > maxPoints) {
                maxPoints = sum;
                bestMovie = movie;

            }
            sum = 0;
            if (countMovies >= 7) {
                System.out.println("The limit is reached.");
                break;
            }
            movie = scan.nextLine();
        }
        System.out.printf("The best movie for you is %s with %d ASCII sum.", bestMovie, maxPoints);
    }
}

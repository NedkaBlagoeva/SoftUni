package MoreExercises.SimpleOperationsAndCalculations;
import java.util.Scanner;

public class WeatherForecast_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String weather = scan.next();

        if (weather.equals("sunny" )) {
            System.out.println("It's warm outside!");
        }
        else
        System.out.println("It's cold outside!");

    }
}

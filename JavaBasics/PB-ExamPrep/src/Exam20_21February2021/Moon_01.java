import java.util.Scanner;

public class Moon_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double avrgSpeed = Double.parseDouble(scan.nextLine());
        double litresPer100km = Double.parseDouble(scan.nextLine());

        double totalDistance = 384400 * 2;
        double time = Math.ceil(totalDistance / avrgSpeed);
        double totalTime = time + 3;
        double totalFuel = totalDistance / 100 * litresPer100km;

        System.out.printf("%.0f\n", totalTime);
        System.out.printf("%.0f", totalFuel);


    }
}


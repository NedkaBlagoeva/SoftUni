package FirstStepsInCoding_Exercise;
import java.util.Scanner;

public class FishTank_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tankLength = Integer.parseInt(scan.nextLine());
        int tankWidth = Integer.parseInt(scan.nextLine());
        int tankHigh = Integer.parseInt(scan.nextLine());
        double percent = (Double.parseDouble(scan.nextLine()))/100;

        double volume = tankLength*1.0*tankWidth*tankHigh/1000;
        double litre = volume - volume*percent;
        //System.out.println(volume);
        System.out.printf("%.2f",litre);
    }
}

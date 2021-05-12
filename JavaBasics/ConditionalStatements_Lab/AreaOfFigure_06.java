package ConditionalStatements_Lab;
import java.util.Scanner;

public class AreaOfFigure_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String shape = scan.nextLine();
        double a = Double.parseDouble(scan.nextLine());
        double area = 0;

        if (shape.equals("square")){
            area = a*a;
        } else if (shape.equals("rectangle")) {
            double b = Double.parseDouble(scan.nextLine());
            area = a*b;
        } else if (shape.equals("circle")) {
            area = a*a*Math.PI;
        } else if (shape.equals("triangle")) {
            double ha = Double.parseDouble(scan.nextLine());
            area = a*ha/2;
        } System.out.printf("%.3f", area);
    }
}

package DataTypesAndVariables_Ex;

import java.util.Scanner;

public class _10_PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pokePowerN = Integer.parseInt(scan.nextLine());
        int startPower = pokePowerN;
        int distanceM = Integer.parseInt(scan.nextLine());
        int exhaustionFactorY = Integer.parseInt(scan.nextLine());
        int count = 0;

        while (pokePowerN >= distanceM) {
            pokePowerN -= distanceM;
            count++;
            if (pokePowerN == startPower / 2) {
                pokePowerN /= exhaustionFactorY;
            }
        }
        System.out.println(pokePowerN);
        System.out.println(count);

    }
}

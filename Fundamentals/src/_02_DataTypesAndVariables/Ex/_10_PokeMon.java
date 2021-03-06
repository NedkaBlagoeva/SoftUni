package _02_DataTypesAndVariables.Ex;

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
                if (exhaustionFactorY != 0){
                    pokePowerN /= exhaustionFactorY;
                }
            }
        }
        System.out.println(pokePowerN);
        System.out.println(count);

    }
}

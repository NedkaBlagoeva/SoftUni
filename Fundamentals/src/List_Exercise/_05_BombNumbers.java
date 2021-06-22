package List_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int[] bombAndPower = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int bomb = bombAndPower[0];
        int power = bombAndPower[1];
        int bombIndex = 0;
        //върти, докато има бомба
        while (numbers.contains(bomb)) {
            //намираме бомбата
            for (int i = 0; i < numbers.size(); i++) {
                if (bomb == numbers.get(i)) {
                    bombIndex = i;
                }
            }
            //индекси за нулиране
            int startIndex = bombIndex - power;
            int last = bombIndex + power;
            if (startIndex < 0) {
                startIndex = 0;
            }
            if (last > numbers.size() - 1) {
                last = numbers.size() - 1;
            }
            //заместваме всички индекси в обсега на бомбата с нула
            for (int j = startIndex; j <= last; j++) {
                numbers.set(j, 0);
            }
        }
        //печат
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}

package _02_FundamentalsMidExam;

import java.util.*;
import java.util.stream.Collectors;

public class _03_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        double averageNum = sum * 1.0 / numbers.size();
        numbers.removeIf(p -> p <= averageNum);

        List<Integer> top5 = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int maxNum = Integer.MIN_VALUE;
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j) > maxNum) {
                    maxNum = numbers.get(j);
                }
            }
            if (maxNum == Integer.MIN_VALUE) {
                System.out.println("No");
                return;
            }
            top5.add(maxNum);
            numbers.remove(Integer.valueOf(maxNum));
            if (numbers.isEmpty()) {
                break;
            }
        }
        Collections.sort(top5);
        Collections.reverse(top5);
        for (Integer integer : top5) {
            System.out.print(integer + " ");
        }
    }
}

package _05_Lists.Exercese;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07_AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 1 2 3 |4 5 6 |  7  8
        List<String> numbersArr = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());
        Collections.reverse(numbersArr);
        String output = numbersArr.toString()
                .replace("[", "")
                .replace("]", "")
                .replaceAll(",", "")
                .trim()
                .replaceAll("\\s+", " ");
        System.out.println(output);
    }
}

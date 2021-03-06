package _05_Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> list1 = Arrays.stream(scan.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int minListSize = Math.min(list1.size(), list2.size());
        for (int i = 0; i < minListSize; i++) {
            System.out.print(list1.get(i) + " " + list2.get(i) + " ");
        }
        printList(list1, minListSize);
        printList(list2, minListSize);
    }

    private static void printList(List<Integer> list, int beginIndex) {
        for (int i = beginIndex; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}

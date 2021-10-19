package _02_MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int degree = Integer.parseInt(input.substring(input.indexOf("(") + 1, input.indexOf(")")));
        //logic how to rotate matrix


        List<String> inputData = new ArrayList<>();
        String inputStrings = scan.nextLine();
        while (!inputStrings.equals("END")){
            inputData.add(inputStrings);
            inputStrings = scan.nextLine();
        }
        inputData
    }
}

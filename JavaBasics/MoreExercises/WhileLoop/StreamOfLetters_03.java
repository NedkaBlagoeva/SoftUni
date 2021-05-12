package MoreExercises.WhileLoop;

import java.util.Scanner;

public class StreamOfLetters_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String print = "";
        String word = "";
        int countC = 0;
        int countO = 0;
        int countN = 0;
        String input = scan.nextLine();
        while (!input.equals("End")){
            char symbol = input.charAt(0);
            if ((((symbol >= 'a' || symbol <= 'z') || (symbol >= 'A' || symbol <= 'Z')) && Character.isAlphabetic(symbol))){
                if ((symbol == 'c' || symbol == 'o' || symbol == 'n') && (countC == 0 || countO == 0 || countN == 0)) {
                    switch (symbol) {
                        case 'c':
                            if (countC == 1){
                                word += symbol;
                                break;
                            } else {
                                countC++;
                            }
                            break;
                        case 'o':
                            if (countO == 1){
                                word += symbol;
                                break;
                            } else {
                                countO++;
                            }
                            break;
                        case 'n':
                            if (countN == 1){
                                word += symbol;
                                break;
                            } else {
                                countN++;
                            }
                            break;
                    }
                } else {
                    word += symbol;
                }
                if ((symbol == 'c' || symbol == 'o' || symbol == 'n') && (countC == 1 && countO == 1 && countN == 1)){
                    word += " ";
                    print += word;
                    countC = 0;
                    countO = 0;
                    countN = 0;
                    word = "";
                }
            }
            input = scan.nextLine();
        }
        System.out.println(print);
    }
}

package ConditionalStatementsAdvanced_Lab;

import java.util.Scanner;

public class PersonelTutles_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        Mr." - мъж (пол "m") на 16 или повече години
//•	    "Master" - момче (пол "m") под 16 години
//•	    "Ms." - жена (пол "f") на 16 или повече години
//•	    "Miss" - момиче (пол "f") под 16 години

        double age = Double.parseDouble(scan.nextLine());
        String gender = scan.nextLine();

        switch (gender){
            case "m":
                if (age>=16){
                    System.out.println("Mr.");
                }else {
                    System.out.println("Master");
                }

                break;
            case "f":
                if (age >=16){
                    System.out.println("Ms.");
                }else {
                    System.out.println("Miss");
                }
                break;
        }

    }
}

package WhileLoop_Exercise;

import java.util.Scanner;

public class OldBooks_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String searchedBook = scan.nextLine();
        String currentBook = scan.nextLine();
        int bookCount = 0;

        while (!searchedBook.equals(currentBook)) {
            if (currentBook.equals("No More Books")) {
                break;
            }
            bookCount++;
            currentBook = scan.nextLine();
        }
        if (currentBook.equals(searchedBook)) {
            System.out.printf("You checked %d books and found it.", bookCount);
        }else {
            System.out.printf("The book you search is not here!\n" +
                    "You checked %d books.", bookCount);
        }
    }
}

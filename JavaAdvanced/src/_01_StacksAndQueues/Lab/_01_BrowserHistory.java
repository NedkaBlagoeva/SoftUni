package _01_StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();
        String url = scan.nextLine();
        String currentUrl = "";
        while (!url.equals("Home")) {
            if (url.equals("back")) {
                if (history.isEmpty() || history.size() == 1) {
                    System.out.println("no previous URLs");
                    url = scan.nextLine();
                    continue;
                } else {
                    history.pop();
                    System.out.println(history.peek());
                }
            } else {
                history.push(url);
                System.out.println(url);
            }
            url = scan.nextLine();
        }

    }
}

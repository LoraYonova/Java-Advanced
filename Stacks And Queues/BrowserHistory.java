package StacksAndQueques;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();

        String input = scan.nextLine();

        String currentPage = "";

        while (!input.equals("Home")) {


            if (input.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scan.nextLine();
                    continue;
                }
                String prevURl = history.pop();
                currentPage = prevURl;


            } else {
                if (!currentPage.equals("")) {
                    history.push(currentPage);

                }
                currentPage = input;
            }

            System.out.println(currentPage);


            input = scan.nextLine();
        }


    }
}

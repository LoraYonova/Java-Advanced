package StacksAndQueques;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();


        while (!input.equals("print")) {

            if (input.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.peek());
                    queue.pollFirst();
                }

            } else {
                queue.offer(input);
            }


            input = scan.nextLine();
        }
        if (!queue.isEmpty()) {

            queue.forEach(System.out::println);
        }


    }
}

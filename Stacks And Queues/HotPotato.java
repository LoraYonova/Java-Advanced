package StacksAndQueques;

import java.util.*;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] children = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> child = new ArrayDeque<>();
        Collections.addAll(child, children);

        while (child.size() > 1) {
            for (int i = 1; i < n; i++) {

                child.offer(child.poll());

            }
                System.out.println("Removed " + child.poll());
        }
            System.out.println("Last is " + child.poll());



    }
}

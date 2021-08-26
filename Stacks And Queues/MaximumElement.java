package StacksAndQueques;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            int[] command = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            if (command[0] == 1) {
                int number = command[1];
                stack.push(number);


            } else if (command[0] == 2) {
                stack.pop();


            } else if (command[0] == 3) {
                System.out.println(Collections.max(stack));

            }

        }


    }
}

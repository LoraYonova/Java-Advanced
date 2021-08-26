package StacksAndQueques;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] elements = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int elementOffer = elements[0];
        int elementPoll = elements[1];
        int elementCheck = elements[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int [] allElements = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < elementOffer; i++) {
            queue.offer(allElements[i]);
        }

        for (int i = 0; i < elementPoll; i++) {

            queue.poll();

        }

        if (queue.contains(elementCheck)) {
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(Collections.min(queue));

        }

    }
}

package StacksAndQueques;

import java.util.ArrayDeque;
import java.util.Arrays;

import java.util.Collections;
import java.util.Scanner;


public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] elements = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int elementsToPush = elements[0];
        int elementsToPop = elements[1];
        int elementsCheck = elements[2];

        ArrayDeque<Integer> addElements = new ArrayDeque<>();
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < elementsToPush; i++) {
            addElements.push(numbers[i]);

        }


        for (int i = 0; i < elementsToPop; i++) {

            addElements.pop();

        }

        if (addElements.contains(elementsCheck)) {
            System.out.println("true");
        } else if (addElements.isEmpty()) {
            System.out.println("0");

        } else {
            System.out.println(Collections.min(addElements));
        }


    }
}

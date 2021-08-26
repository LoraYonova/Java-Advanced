package StacksAndQueques;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] elements = scan.nextLine().split("\\s+");
        ArrayDeque<Integer> calculator = new ArrayDeque<>();
        int totalSum = 0;

        for (int i = 0; i < elements.length; i++) {
            totalSum = 0;
            String element = elements[i];

            if (element.equals("+")) {
                int firstNum = calculator.pop();
                int second = Integer.parseInt(element = elements[i + 1]);
                totalSum += firstNum + second;
                calculator.push(totalSum);
                i++;


            } else if (element.equals("-")) {
                int firstNum = calculator.pop();
                int second = Integer.parseInt(element = elements[i + 1]);
                totalSum = firstNum - second;
                calculator.push(totalSum);
                i++;


            } else {
                calculator.push(Integer.parseInt(element));
            }


        }

        System.out.println(totalSum);
    }
}

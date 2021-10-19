package MockExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stack::push);

        ArrayDeque<Integer> queue = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int wreaths = 0;
        int remainingFlowers = 0;


        while (!stack.isEmpty() && !queue.isEmpty()) {

            int firstRoses = stack.peek();
            int firstLilies = queue.peek();

            int sum = firstLilies + firstRoses;

            stack.pop();


            if (sum == 15) {
                queue.poll();
                wreaths++;

            } else if (sum > 15) {
                stack.push(firstRoses - 2);

            } else {
                queue.poll();
                remainingFlowers += sum;
            }


        }

        if (remainingFlowers > 15) {
            int result = remainingFlowers / 15;
            wreaths += result;
        }

        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreaths);
        }

    }
}

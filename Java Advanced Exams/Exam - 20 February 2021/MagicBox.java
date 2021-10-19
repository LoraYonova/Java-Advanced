package MockExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> firstMagicBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondMagicBox::push);

        int evenSum = 0;

        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()) {

            int firstBox = firstMagicBox.peek();
            int secondBox = secondMagicBox.peek();

            if ((firstBox + secondBox) % 2 == 0) {

                evenSum += firstBox + secondBox;
                firstMagicBox.poll();
                secondMagicBox.pop();

            } else {
                secondMagicBox.pop();
                firstMagicBox.offer(secondBox);
            }


        }

        if (firstMagicBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if (evenSum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", evenSum);
        } else {
            System.out.printf("Poor prey... Value: %d%n", evenSum);
        }


    }
}

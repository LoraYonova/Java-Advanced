package MockExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(males::push);

        ArrayDeque<Integer> females = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;

        while (!males.isEmpty() && !females.isEmpty()) {

            int malesValue = males.peek();
            int femalesValue = females.peek();

            if (malesValue <= 0) {
                males.pop();
                continue;

            }
            if (femalesValue <= 0) {
                females.poll();
                continue;
            }

            if (malesValue % 25 == 0) {
                males.pop();
                if (!males.isEmpty()) {
                    males.pop();
                }
                continue;
            }
            if (femalesValue % 25 == 0) {
                females.poll();
                if (!females.isEmpty()) {
                    females.poll();
                }
                continue;
            }

            males.pop();
            females.poll();
            if (malesValue != femalesValue) {
                if (malesValue - 2 > 0) {
                    males.push(malesValue - 2);
                }
            } else {
                matches++;
            }

        }
        System.out.println("Matches: " + matches);
        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            String replace = males.toString().replaceAll("[\\[\\]]", "");
            System.out.print(replace);
            System.out.println();
        }

        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            String replace = females.toString().replaceAll("[\\[\\]]", "");
            System.out.print(replace);
            System.out.println();
        }

    }
}

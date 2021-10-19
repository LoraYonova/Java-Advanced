package MockExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(tasks::push);


        ArrayDeque<Integer> threads = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int valueTaskKilled = Integer.parseInt(scan.nextLine());


            while (!threads.isEmpty() && !tasks.isEmpty()) {

                int firstElement = threads.peek();
                int secondElement = tasks.peek();

                if (secondElement == valueTaskKilled) {
                    System.out.printf("Thread with value %d killed task %d%n", firstElement, secondElement);
                    break;
                }

                if (firstElement >= secondElement) {
                    threads.poll();
                    tasks.pop();
                } else {
                    threads.pop();

                }

            }
        System.out.println(threads.toString().replaceAll("[\\[\\],]", ""));

    }
}

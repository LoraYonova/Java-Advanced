package MockExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> queue = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stack::push);
        int sumOfClaimedItems = 0;

      while (!queue.isEmpty() && !stack.isEmpty()) {

          int firstBox = queue.peek();
          int secondBox = stack.peek();
          int sum = firstBox + secondBox;

          if (sum % 2 == 0) {
              sumOfClaimedItems += sum;
              queue.poll();
              stack.pop();
          } else {
              stack.pop();
              queue.offer(secondBox);

          }

      }

      if (queue.isEmpty()) {
          System.out.println("First lootbox is empty");
      } else {
          System.out.println("Second lootbox is empty");
      }

      if (sumOfClaimedItems >= 100) {
          System.out.printf("Your loot was epic! Value: %d%n", sumOfClaimedItems);
      } else {
          System.out.printf("Your loot was poor... Value: %d%n", sumOfClaimedItems);
      }

    }
}

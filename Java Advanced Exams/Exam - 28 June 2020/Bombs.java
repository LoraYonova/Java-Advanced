package MockExams;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> queue = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stack::push);


        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);
        int datura = 0;
        int cherry = 0;
        int smoke = 0;

        boolean isSucceededFulfill = false;
        while (!stack.isEmpty() && !queue.isEmpty()) {

            int secondBomb = queue.peek();
            int firstBomb = stack.peekFirst();
            int sum = firstBomb + secondBomb;

            String result = "";

            if (sum == 40) {
                datura++;
                result = "Datura Bombs";
                bombs.put(result, datura);
                stack.pop();
                queue.poll();

            } else if (sum == 60) {
                cherry++;
                result = "Cherry Bombs";
                bombs.put(result,cherry);
                stack.pop();
                queue.poll();
            } else if (sum == 120) {
                smoke++;
                result = "Smoke Decoy Bombs";
                bombs.put(result, smoke);
                stack.pop();
                queue.poll();
            } else {
                stack.pop();
               stack.push(firstBomb - 5);

            }
            if (datura >= 3 && cherry >= 3 && smoke >= 3) {
                isSucceededFulfill = true;
                break;
            }

        }

        if (isSucceededFulfill) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (queue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            String collect = queue.stream().map(Objects::toString).collect(Collectors.joining(", "));
            System.out.print(collect);
            System.out.println();
        }

        if (stack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            String collect = stack.stream().map(Objects::toString).collect(Collectors.joining(", "));
            System.out.print(collect);
            System.out.println();
        }

        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


    }
}

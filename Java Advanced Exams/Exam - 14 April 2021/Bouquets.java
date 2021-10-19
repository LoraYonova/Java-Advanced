package MockExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tulips::push);


        ArrayDeque<Integer> daffodils = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int countBouquets = 0;
        int remainingFlowers = 0;

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {

            int tulip = tulips.peek();
            int daffodil = daffodils.peek();

            if (tulip + daffodil == 15) {
                tulips.pop();
                daffodils.poll();
                countBouquets++;

            } else if (tulip + daffodil > 15) {
                tulips.pop();
                tulips.push(tulip - 2);
            } else {
                remainingFlowers += tulip + daffodil;
                tulips.pop();
                daffodils.poll();
            }


        }

        if (remainingFlowers >= 15) {
            while (remainingFlowers > 15) {
                remainingFlowers -= 15;
                countBouquets++;
            }
        }

        if (countBouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n" , countBouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.%n" , 5 - countBouquets);
        }

    }
}

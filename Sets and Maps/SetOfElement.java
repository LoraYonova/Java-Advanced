package SetsAndMaps;

import java.util.*;

public class SetOfElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int n = numbers[0];
        int m = numbers[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        while (n-- > 0) {
           int number = Integer.parseInt(scan.nextLine());
            firstSet.add(number);
        }

        while (m-- > 0) {
            int number = Integer.parseInt(scan.nextLine());
            secondSet.add(number);

        }

            firstSet.retainAll(secondSet);

        firstSet.forEach(e -> System.out.print(e + " "));





    }
}

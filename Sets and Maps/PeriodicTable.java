package SetsAndMaps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Set<String> element = new TreeSet<>();
        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");
            element.addAll(Arrays.asList(input));

        }

        element.forEach(e -> System.out.print(e + " "));


    }
}

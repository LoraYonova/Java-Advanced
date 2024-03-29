package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = Integer.parseInt(scan.nextLine());

        String[] names = scan.nextLine().split("\\s+");

        Predicate<String> checkTheLength = n -> n.length() <= length;

        Arrays.stream(names).filter(checkTheLength).forEach(System.out::println);




    }
}

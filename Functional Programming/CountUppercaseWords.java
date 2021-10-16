package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] text = scan.nextLine().split("\\s+");

        Predicate<String> predicate = word -> Character.isUpperCase(word.charAt(0));

        List<String> upperCaseString = Arrays.stream(text)
                .filter(predicate)
                .collect(Collectors.toList());

        System.out.println(upperCaseString.size());
        System.out.println(String.join(System.lineSeparator(), upperCaseString));



    }
}

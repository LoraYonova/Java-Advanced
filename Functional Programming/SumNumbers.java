package FunctionalProgramming;


import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Consumer<String> length = l -> System.out.println("Count = " + l.split(", ").length);

        Function<String, Integer> sum = x -> Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .sum();


        length.accept(input);
        System.out.println("Sum = " + sum.apply(input));


    }
}

package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        String input = scan.nextLine();

        Function<List<Integer>, List<Integer>> add = num -> num.stream().map(n -> n += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = num -> num.stream().map(n -> n *= 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = num -> num.stream().map(n -> n -= 1).collect(Collectors.toList());

        boolean isPrint = false;

        while (!input.equals("end")) {

            if (input.equals("add")) {
                numbers = add.apply(numbers);

            } else if (input.equals("multiply")) {
                numbers = multiply.apply(numbers);

            } else if (input.equals("subtract")) {
               numbers = subtract.apply(numbers);

            } else if (input.equals("print")) {

                numbers.forEach(e -> System.out.print(e + " "));
                System.out.println();

            }




            input = scan.nextLine();
        }


    }
}

package StacksAndQueques;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> nums = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            nums.push(numbers[i]);


        }
        for (Integer num : nums) {
            System.out.print(num + " ");
        }



//        List<Integer> num = Arrays.stream(scan.nextLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        Collections.reverse(num);
//        num.forEach(e -> System.out.print(e + " "));



    }
}

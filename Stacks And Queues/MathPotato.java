package StacksAndQueques;


import java.util.ArrayDeque;
import java.util.Arrays;

import java.util.Scanner;
import java.util.stream.Collectors;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> children = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int n = Integer.parseInt(scan.nextLine());


        int cycle = 1;

        while (children.size() > 1) {
            for (int i = 1; i < n; i++) {
                children.offer(children.poll());


            }
            if(isPrime(cycle)) {
                System.out.println("Prime " + children.peek());
            } else {
                System.out.println("Removed " + children.poll());
            }
            cycle++;
        }

        String lastName = children.poll();
        System.out.println("Last is " + lastName);




    }

    private static boolean isPrime(int cycle) {
        boolean prime = true;
        if(cycle == 0 || cycle == 1) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(cycle); i++) {
                if (cycle % i == 0) {
                    prime = false;
                }

            }
            return prime;
        }
    }
}

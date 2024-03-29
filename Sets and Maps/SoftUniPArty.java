package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniPArty {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Set<String> guests = new TreeSet<>();

        while (!input.equals("PARTY")) {
            guests.add(input);

            input = scan.nextLine();
        }

        while (!input.equals("END")) {
            guests.remove(input);

            input = scan.nextLine();
        }

        System.out.println(guests.size());

        for (String guest : guests) {
            System.out.println(guest);
        }

    }
}

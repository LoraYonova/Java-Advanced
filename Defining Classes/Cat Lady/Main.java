package CatLady;

import java.util.LinkedHashMap;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<String, Cats> cat = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String breed = input.split("\\s+")[0];
            String name = input.split("\\s+")[1];
            double characteristic = Double.parseDouble(input.split("\\s+")[2]);

            Cats cats = new Cats(breed,name,characteristic);
            cat.put(name, cats);

            input = scan.nextLine();
        }

        String name = scan.nextLine();

        System.out.println(cat.get(name).toString());



    }
}

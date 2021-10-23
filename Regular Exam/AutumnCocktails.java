package AutumnCocktails;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> ingredients = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(freshness::push);

        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);
        int pear = 0;
        int harvest = 0;
        int apple = 0;
        int fashion = 0;


        while (!freshness.isEmpty() && !ingredients.isEmpty()) {

            int ingredientValue = ingredients.peek();
            int freshnessValue = freshness.peek();

            int multiply = ingredientValue * freshnessValue;

            String result = "";


            if (ingredientValue == 0) {
                ingredients.poll();
                continue;

            }

            freshness.pop();
            ingredients.poll();

            if (multiply == 150) {
                result = "Pear Sour";
               pear++;
               cocktails.put(result, pear);


            } else if (multiply == 250) {
                result = "The Harvest";
               harvest++;
               cocktails.put(result, harvest);


            } else if (multiply == 300) {
                result = "Apple Hinny";
              apple++;
              cocktails.put(result,apple);

            } else if (multiply == 400) {
                result = "High Fashion";
                fashion++;
              cocktails.put(result, fashion);


            } else {
                ingredients.offerLast(ingredientValue + 5);
            }


        }

            boolean isAPartyTime = false;
        for (Integer value : cocktails.values()) {
            if (value != 0) {
                isAPartyTime = true;
            } else {
                isAPartyTime = false;
                break;
            }
        }

        if (isAPartyTime) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredients.isEmpty()) {
            int sum = 0;
            for (Integer q : ingredients) {
                sum += q;
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }

        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(" # " + entry.getKey() + " --> " + entry.getValue());
            }
        }

    }
}

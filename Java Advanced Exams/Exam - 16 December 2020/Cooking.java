package MockExams;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> liquids = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

                ArrayDeque<Integer> ingredients = new ArrayDeque<>();
                        Arrays.stream(scan.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .forEach(ingredients::push);

        Map<String, Integer> food = new LinkedHashMap<>();

        food.put("Bread", 0);
        food.put("Cake", 0);
        food.put("Fruit Pie", 0);
        food.put("Pastry", 0);

                while (!ingredients.isEmpty() && !liquids.isEmpty()) {

                    int liquid = liquids.peek();
                    int ingredient = ingredients.peek();
                    int sum = 0;

                    sum += liquid + ingredient;

                    ingredients.pop();
                    liquids.poll();

                    if (sum == 25) {
                        food.put("Bread", food.get("Bread") + 1);

                    } else if (sum == 50) {
                        food.put("Cake", food.get("Cake") + 1);

                    } else if(sum == 75) {
                        food.put("Pastry", food.get("Pastry") + 1);

                    } else if(sum == 100) {
                        food.put("Fruit Pie", food.get("Fruit Pie") + 1);

                    } else {
                        ingredients.push(ingredient + 3);
                    }


                }
                int count = 0;
        for (Integer value : food.values()) {
            if (value >= 1) {
                count++;
            }
        }
        if (count == 4) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            System.out.println(liquids.toString().replaceAll("[\\[\\]]", ""));
        }

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            System.out.println(ingredients.toString().replaceAll("[\\[\\]]", ""));

        }


                food.entrySet().stream().forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());



                });


    }
}

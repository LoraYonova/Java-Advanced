package MockExams;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> liquids = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s++"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        Map<String, Integer> food = new LinkedHashMap<>();

        food.put("Biscuit" , 0);
        food.put("Cake" , 0);
        food.put("Pie" , 0);
        food.put("Pastry", 0);

        int biscuitCount = 0;
        int cakeCount = 0;
        int pieCount = 0;
        int pastryCount = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()){
            int elementLiquids = liquids.peek();
            int elementIngredients = ingredients.peek();
            int sum = elementIngredients + elementLiquids;

            String result = "";
            liquids.poll();
            ingredients.pop();

            if (sum == 25) {
                biscuitCount++;
                result = "Biscuit";
                food.put(result, biscuitCount);

            } else if (sum == 50) {
                result = "Cake";
                cakeCount++;
                food.put(result,cakeCount);

            } else if (sum == 75) {
                result = "Pastry";
                pastryCount++;
                food.put(result, pastryCount);


            } else if (sum == 100) {
                result = "Pie";
                pieCount++;
                food.put(result, pieCount);

            } else {
                ingredients.push(elementIngredients + 3);

            }

        }

        boolean youSucceeded = false;
        for (Integer value : food.values()) {
            if (value != 0) {
                youSucceeded = true;
            } else {
                youSucceeded = false;
                break;
            }
        }
        if (youSucceeded) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            System.out.print(liquids.toString().replaceAll("[\\[\\]]", ""));
            System.out.println();
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            System.out.print(ingredients.toString().replaceAll("[\\[\\]]", ""));
            System.out.println();
        }

        for (Map.Entry<String, Integer> entry : food.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}

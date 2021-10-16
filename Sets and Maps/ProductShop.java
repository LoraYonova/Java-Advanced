package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, Map<String, Double>> shopsAndProducts = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] commands = input.split(", ");
            String shop = commands[0];
            String product = commands[1];
            double price = Double.parseDouble(commands[2]);

            if (!shopsAndProducts.containsKey(shop)) {
                shopsAndProducts.put(shop, new LinkedHashMap<>());
            }
            shopsAndProducts.get(shop).put(product, price);


            input = scan.nextLine();
        }


        for (String shop : shopsAndProducts.keySet()) {
            System.out.println(shop + "->");
            for (Map.Entry<String, Double> entry : shopsAndProducts.get(shop).entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", entry.getKey(), entry.getValue());
            }
        }

    }
}

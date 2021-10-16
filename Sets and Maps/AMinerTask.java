package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String resource = scan.nextLine();

        Map<String, Integer> resourceAndQuantity = new LinkedHashMap<>();

        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scan.nextLine());

            if (!resourceAndQuantity.containsKey(resource)) {
                resourceAndQuantity.put(resource, quantity);

            } else {
                resourceAndQuantity.put(resource, resourceAndQuantity.get(resource) + quantity);

            }


            resource = scan.nextLine();
        }



        resourceAndQuantity.forEach((key, value) -> System.out.println(key + " -> " + value));


    }
}

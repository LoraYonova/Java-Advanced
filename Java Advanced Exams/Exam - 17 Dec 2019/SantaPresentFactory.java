package MockExams;

import java.util.*;
import java.util.stream.Collectors;

public class SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> materials = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(materials::push);

        ArrayDeque<Integer> magic = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> boxOfToy = new TreeMap<>();


        while (!materials.isEmpty() && !magic.isEmpty()) {

            int valueBox = materials.peek();
            int valueMagic = magic.peek();
            int total = valueBox * valueMagic;

            if (valueBox == 0 || valueMagic == 0) {
                if (valueBox == 0) {
                    materials.pop();
                }
                if (valueMagic == 0) {
                    magic.poll();
                }
                continue;
            }

            if (total < 0) {
                int sum = valueBox + valueMagic;
                materials.pop();
                magic.poll();
                materials.push(sum);
                continue;
            }

            materials.pop();
            magic.poll();
            String gift = "";

            if (total == 150) {
                gift = "Doll";
                boxOfToy.putIfAbsent(gift, 0);
                boxOfToy.put(gift, boxOfToy.get(gift) + 1);

            } else if (total == 250) {
                gift = "Wooden train";
                boxOfToy.putIfAbsent(gift, 0);
                boxOfToy.put(gift, boxOfToy.get(gift) + 1);

            } else if (total == 300) {
                gift = "Teddy bear";
                boxOfToy.putIfAbsent(gift, 0);
                boxOfToy.put(gift, boxOfToy.get(gift) + 1);

            } else if (total == 400) {
                gift = "Bicycle";
                boxOfToy.putIfAbsent(gift, 0);
                boxOfToy.put(gift, boxOfToy.get(gift) + 1);


            } else {
                materials.push(valueBox + 15);

            }


        }

        if ((boxOfToy.containsKey("Doll") && boxOfToy.containsKey("Wooden train")) ||
                (boxOfToy.containsKey("Teddy bear") && boxOfToy.containsKey("Bicycle"))) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materials.isEmpty()) {
            System.out.print("Materials left: ");
            String collect = materials.stream().map(Objects::toString).collect(Collectors.joining(", "));
            System.out.print(collect);
            System.out.println();

        }

        if (!magic.isEmpty()) {
            System.out.print("Magic left: ");
            String collect = magic.stream().map(Objects::toString).collect(Collectors.joining(", "));
            System.out.print(collect);
            System.out.println();
        }

        for (Map.Entry<String, Integer> entry : boxOfToy.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


    }
}

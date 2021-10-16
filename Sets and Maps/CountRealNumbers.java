package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double [] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> valuesWithOccurrences = new LinkedHashMap<>();

        for (double number : numbers) {
            if (!valuesWithOccurrences.containsKey(number)) {
                valuesWithOccurrences.put(number, 1);
            } else {

                valuesWithOccurrences.put(number, valuesWithOccurrences.get(number) + 1);
            }
        }

        for (Double key : valuesWithOccurrences.keySet()) {
            System.out.println(String.format("%.1f -> %d", key, valuesWithOccurrences.get(key)));
        }


    }
}

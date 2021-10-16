package SetsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<Character, Integer> contOfLetter = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (!contOfLetter.containsKey(symbol)) {
                contOfLetter.put(symbol, 1);
            } else {

                contOfLetter.put(symbol, contOfLetter.get(symbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : contOfLetter.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }


    }
}

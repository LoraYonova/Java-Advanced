package SetsAndMaps;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, Set<String>> valuesOfPlayers = new LinkedHashMap<>();


        while (!input.equals("JOKER")) {

            String[] command = input.split(": ");
            String name = command[0];
            String[] cards = command[1].split(", ");

            if (!valuesOfPlayers.containsKey(name)) {
                valuesOfPlayers.put(name, new LinkedHashSet<>());

                Collections.addAll(valuesOfPlayers.get(name), cards);
            } else {
                Set<String> oldCard = valuesOfPlayers.get(name);
                Collections.addAll(oldCard, cards);
            }


            input = scan.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : valuesOfPlayers.entrySet()) {
            int sum =  getValueOfCards(entry.getValue());
            System.out.println(entry.getKey() + ": " + sum);
        }


    }

    private static int getValueOfCards(Set<String> value) {
        Map<Character, Integer> pointsMap = getPartOfCardValue();
        int cardSum = 0;
        for (String card : value) {
            int points = 0;
            if (card.contains("10")) {
                char type = card.charAt(2);
                 points = 10 * pointsMap.get(type);
            } else {
                char number = card.charAt(0);
                char type = card.charAt(1);
                points = pointsMap.get(number) * pointsMap.get(type);
            }
            cardSum += points;


        }
        return cardSum;
    }

    private static Map<Character, Integer> getPartOfCardValue() {
        Map<Character, Integer> points = new HashMap<>();
        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);
        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);
        return points;
    }
}

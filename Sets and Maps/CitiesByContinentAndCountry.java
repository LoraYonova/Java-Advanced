package SetsAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, List<String>>> continentCountryAndCities = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");

            String continent = input[0];
            String country = input[1];
            String city = input[2];


            continentCountryAndCities.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> map = continentCountryAndCities.get(continent);
            map.putIfAbsent(country, new ArrayList<>());
            List<String> cities = map.get(country);
            cities.add(city);


        }

        continentCountryAndCities.entrySet()
                .stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + ":");

                    for (Map.Entry<String, List<String>> s : e.getValue().entrySet()) {

                                System.out.println("  " + s.getKey() + " -> " + String.join(", " + s.getValue()));
                    }


                });


    }
}

package SetsAndMaps;

import java.util.*;


public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();

        String input = scan.nextLine();


        while (!input.equals("end")) {
            String[] command = input.split("\\s+");
            String IP = command[0].split("=")[1];
            String user = command[2].split("=")[1];

//            userLogs.putIfAbsent(user, new LinkedHashMap<>());
//            userLogs.get(user).putIfAbsent(IP, 0);
//            userLogs.get(user).put(IP, userLogs.get(user).get(IP) + 1);

            if (!userLogs.containsKey(user)) {
                userLogs.put(user, new LinkedHashMap<>());
                Map<String, Integer> map = userLogs.get(user);
                map.put(IP, 1);

            } else {
                Map<String, Integer> map = userLogs.get(user);
                if (!map.containsKey(IP)) {
                    map.put(IP, 1);
                } else {

               int key = map.get(IP);
               map.put(IP, key + 1);
                }

            }


            input = scan.nextLine();
        }

        userLogs.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + ": ");

                    int count = 0;
                    Map<String, Integer> value = e.getValue();

                    for (Map.Entry<String, Integer> secondMap : value.entrySet()) {

                        String format =
                                (count++ == value.size() - 1)
                                        ? "%s => %d.%n"
                                        : "%s => %d, ";

                        System.out.printf(format, secondMap.getKey(), secondMap.getValue());
                    }


                });
    }


}

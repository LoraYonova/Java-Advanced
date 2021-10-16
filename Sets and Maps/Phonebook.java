package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        Map<String, String > phonebook = new LinkedHashMap<>();

        while (!command.equals("search")) {
            String[] input = command.split("-");
            String name = input[0];
            String phoneNumber = input[1];

            phonebook.put(name, phoneNumber);


            command = scan.nextLine();
        }

            command = scan.nextLine();
        while (!command.equals("stop")) {

            if (phonebook.containsKey(command)) {
                for (Map.Entry<String, String> entry : phonebook.entrySet()) {
                    if (entry.getKey().equals(command)) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }
                }
            } else {
                System.out.printf("Contact %s does not exist.%n", command);
            }




            command = scan.nextLine();
        }


    }
}

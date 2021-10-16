package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FIxEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();

        Map<String, String> emails = new LinkedHashMap<>();


        while (!name.equals("stop")) {
            String email = scan.nextLine();

           if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
               emails.put(name, email);
           }
            name = scan.nextLine();
        }




        emails.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        }

    }


package SetsAndMaps;

import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Set<String> parkingInfo = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] commands = input.split(", ");
            String command = commands[0];
            String carNumber = commands[1];

            if (command.equals("IN")) {
               parkingInfo.add(carNumber);
            } else if (command.equals("OUT")) {
                parkingInfo.remove(carNumber);
            }


            input = scan.nextLine();
        }

        if (parkingInfo.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String number : parkingInfo) {
                System.out.println(number);
            }
        }


    }
}

package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CustomList<String> list = new CustomList<String>();

        String input = scan.nextLine();

        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            if (command[0].equals("Add")) {
                list.add(command[1]);

            } else if (command[0].equals("Max")) {
                System.out.println(list.getMax());

            } else if (command[0].equals("Min")) {
                System.out.println(list.getMin());

            } else if(command[0].equals("Greater")) {
                String element = command[1];
                System.out.println(list.countGreaterThan(element));

            } else if (command[0].equals("Swap")) {
                int firstIndex = Integer.parseInt(command[1]);
                int secondIndex = Integer.parseInt(command[2]);
                list.swap(firstIndex,secondIndex);

            } else if (command[0].equals("Contains")) {
                String element = command[1];
                System.out.println(list.contains(element));

            } else if (command[0].equals("Remove")) {
                int index = Integer.parseInt(command[1]);
                list.remove(index);
            } else if (command[0].equals("Print")) {
                for (String element : list) {
                    System.out.println(element);
                }
            }

            input = scan.nextLine();
        }

    }
}

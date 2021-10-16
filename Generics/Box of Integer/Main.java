package GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Box<Integer> box = new Box<>();

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            int number = Integer.parseInt(scan.nextLine());
            box.add(number);

        }
        System.out.println(box);


    }
}

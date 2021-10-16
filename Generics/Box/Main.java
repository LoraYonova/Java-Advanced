package GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Box<String> box = new Box<>();

        int n = Integer.parseInt(scan.nextLine());


        while (n-- > 0) {
        String text = scan.nextLine();
        box.add(text);

        }

        System.out.println(box);


    }



}

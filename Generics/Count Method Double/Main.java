package GenericSwapMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Box<Double> box = new Box<>();

        int n = Integer.parseInt(scan.nextLine());


        while (n-- > 0) {
           double number = Double.parseDouble(scan.nextLine());
            box.add(number);

        }
        Double valueOfElement = Double.parseDouble(scan.nextLine());



        System.out.println(box.greaterCountOfElement(valueOfElement));


    }


}

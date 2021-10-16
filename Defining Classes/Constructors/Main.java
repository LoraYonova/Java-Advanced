package DefinigClassesConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Constructor> cars = new ArrayList<>();


        while (n-- > 0) {

            Constructor car;
            String[] input = scan.nextLine().split("\\s+");

            if (input.length == 1) {

                car = new Constructor(input[0]);

            } else {
                car = new Constructor(input[0], input[1], Integer.parseInt(input[2]));
            }

            cars.add(car);


        }
        for (Constructor car : cars) {
            System.out.println(car);
        }


    }
}

package DefiningClasesCar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Car car = new Car();

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");
            car.setBrand(input[0]);
            car.setModel(input[1]);
            car.setHorsePower(Integer.parseInt(input[2]));

            System.out.println(car.toString());



        }


    }
}

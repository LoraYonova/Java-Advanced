package ClassesSpeedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Car>cars = new ArrayList<>();

        while (n-- > 0) {

            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCostFor1Km = Double.parseDouble(input[2]);

            Car car = new Car(model,fuelAmount,fuelCostFor1Km,0);
            cars.add(car);

        }

        String input = scan.nextLine();


        while (!input.equals("End")) {
            String[] commands = input.split("\\s+");
            String command = commands[0];
            String model = commands[1];
            double distance = Double.parseDouble(commands[2]);

            if (command.equals("Drive") && !cars.isEmpty()) {
                double fuelCostFor1Km = cars.stream().filter(c -> c.getModel().equals(model)).findFirst().get().getFuelCostFor1Km(model);
                double fuelAmount = cars.stream().filter(c -> c.getModel().equals(model)).findFirst().get().getFuelAmount(model);
                fuelCostFor1Km *= distance;

                if (fuelAmount >= fuelCostFor1Km) {
                    double newFuelAmount = fuelAmount - fuelCostFor1Km;
                    cars.stream().filter(c -> c.getModel().equals(model)).findFirst().get().setFuelAmount(newFuelAmount);
                    double oldDistance = cars.stream().filter(c -> c.getModel().equals(model)).findFirst().get().getDistance();
                    cars.stream().filter(c -> c.getModel().equals(model)).findFirst().get().setDistance(oldDistance + distance);

                } else {
                    System.out.println("Insufficient fuel for the drive");
                }

            }

            input = scan.nextLine();
        }

        for (Car car1 : cars) {
            System.out.println(car1.toString());
        }


    }


}

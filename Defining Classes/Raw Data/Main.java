package rowData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Car> carInfo = new ArrayList<>();


        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tirePressure1 = Double.parseDouble(input[5]);
            int tireAge1 = Integer.parseInt(input[6]);
            double tirePressure2 = Double.parseDouble(input[7]);
            int tireAge2 = Integer.parseInt(input[8]);
            double tirePressure3 = Double.parseDouble(input[9]);
            int tireAge3 = Integer.parseInt(input[10]);
            double tirePressure4 = Double.parseDouble(input[11]);
            int tireAge4 = Integer.parseInt(input[12]);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tires tires = new Tires(tirePressure1, tireAge1, tirePressure2, tireAge2, tirePressure3, tireAge3, tirePressure4, tireAge4);
            Car car = new Car(model, engine, cargo, tires);
            carInfo.add(car);

        }

        String command = scan.nextLine();

        if (command.equals("fragile")) {
            carInfo.stream().filter(c -> c.getCargo().getCargoType().equals("fragile")).filter(c -> c.getTire().getTirePressure1() < 1
                    || c.getTire().getTirePressure2() < 1
                    || c.getTire().getTirePressure3() < 1
                    || c.getTire().getTirePressure4() < 1)
                    .forEach(c -> System.out.println(c.getModel()));


        } else if (command.equals("flamable")) {
            carInfo.stream()
                    .filter(c -> c.getCargo().getCargoType().equals("flamable"))
                    .filter(c -> c.getEngine().getEnginePower() > 250)
                    .forEach(p -> System.out.println(p.getModel()));

        }


    }
}

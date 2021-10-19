package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void add(Car car) {
        if (capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
       return data.removeIf(m -> m.getManufacturer().equals(manufacturer) && m.getModel().equals(model));

    }

    public Car getLatestCar() {
        if (data.isEmpty()) {
        return null;

        } else {
            return data.stream().max(Comparator.comparing(Car::getYear)).get();

        }
    }


    public Car getCar(String manufacturer, String model) {
        return data.stream()
                .filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("The cars are in a car dealership ");
        builder.append(getName());
        builder.append(":");
        builder.append(System.lineSeparator());
        for (Car car : data) {
            builder.append(car);
            builder.append(System.lineSeparator());
        }
        return builder.toString();

    }
}

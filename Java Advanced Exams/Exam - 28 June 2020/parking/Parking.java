package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }

    public void add(Car car) {
        if (capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
    }

    public Car getLatestCar() {
        return data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return data.stream().filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder(String.format("The cars are parked in %s:%n", type));
        data.forEach(e -> builder.append(e).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}

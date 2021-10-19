package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }


    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (capacity > data.size()) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Present heaviestPresent() {
        return data.stream().max(Comparator.comparing(Present::getWeight)).stream().findFirst().get();
    }

    public Present getPresent(String name) {
        return data.stream().filter(n -> n.getName().equals(name)).findFirst().get();
    }

    public String report() {
        StringBuilder builder = new StringBuilder(String.format("%s bag contains:", getColor()));
        builder.append(System.lineSeparator());
        for (Present d : data) {
            builder.append(d);
            builder.append(System.lineSeparator());

        }
        return builder.toString();
    }
}

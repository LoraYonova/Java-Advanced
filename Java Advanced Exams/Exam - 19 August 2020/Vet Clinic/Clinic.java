package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;


    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (capacity > data.size()) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getOldestPet() {
        return data.stream().max(Comparator.comparing(Pet::getAge)).get();
    }

    public Pet getPet(String name, String owner) {
        return data.stream().filter(p -> p.getName().equals(name) && p.getOwner().equals(owner)).findFirst().get();
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder("The clinic has the following patients:");
        builder.append(System.lineSeparator());
        for (Pet p : data) {
            builder.append(p.getName() + " " + p.getOwner());
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}

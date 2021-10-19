package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (capacity > data.size()) {
            data.add(pet);
        }

    }

    public boolean remove(String name) {

        Pet d = data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (d != null) {
            data.remove(d);
            return true;
        }
        return false;

//        int index = -1;
//        for (int i = 0; i < data.size(); i++) {
//            if (data.get(i).getName().equals(name)) {
//                index = i;
//            }
//        }
//        if (index != -1) {
//            data.remove(index);
//            return true;
//        }
//
//        return false;
    }

    public Pet getPet(String name, String owner) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                return data.get(i);
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder("The grooming salon has the following clients:" + System.lineSeparator());
        for (Pet pet : data) {
            builder.append(pet.getName() + " " + pet.getOwner()).append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}

package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (getCapacity() > this.data.size()) {
            data.add(rabbit);
        }
    }

    public int count() {
        return data.size();
    }

    public boolean removeRabbit(String name) {

        return data.removeIf(n -> n.getName().equals(name));
    }

    public void removeSpecies(String species) {
        data.removeIf(s -> s.getSpecies().equals(species));
    }


    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = null;
        for (Rabbit rabbit1 : data) {
            if (rabbit1.getName().equals(name)) {
                rabbit = rabbit1;
                rabbit.setAvailable();
                break;
            }
        }
        return rabbit;

    }

    public List<Rabbit> sellRabbitBySpecies(String species) {

        List<Rabbit> soldRabbits = data.stream().filter(r -> r.getSpecies().equals(species)).collect(Collectors.toList());

        data.removeIf(x -> x.getSpecies().equals(species));

        return soldRabbits;

    }



    public StringBuilder report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Rabbits available at %s:%n", this.getName()));

        for (Rabbit rabbit : data) {

            if (rabbit.isAvailable()){

            sb.append(rabbit).append(System.lineSeparator());
            }
        }

        return sb;
    }
}

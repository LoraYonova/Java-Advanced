package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (capacity > roster.size()) {
            roster.add(person);
        }
    }

    public int getCount() {
        return roster.size();
    }

    public boolean remove(String name) {
        return roster.removeIf(n -> n.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        return roster.stream().filter(n -> n.getName().equals(name) && n.getHometown().equals(hometown)).findFirst().orElse(null);
    }


    public String getStatistics() {
        StringBuilder builder = new StringBuilder(String.format("The people in the hotel %s are:%n", name));
        for (Person person : roster) {
            builder.append(person);
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}

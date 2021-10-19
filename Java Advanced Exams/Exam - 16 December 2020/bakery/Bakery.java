package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void add(Employee employee) {
        if (capacity > employees.size()) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparing(Employee::getAge)).get();
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(e -> e.getName().equals(name)).findFirst().get();
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employees working at Bakery " + getName() + ":");
        builder.append(System.lineSeparator());
        for (Employee employee : employees) {
            builder.append(employee);
            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }
}

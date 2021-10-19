package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private final String name;
    private final int capacity;
    private final List<Employee> employees;


    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        if (capacity > this.employees.size()) {
            employees.add(employee);
        }
    }



    public Employee getOldestEmployee(){

        return employees.stream().max(Comparator.comparing(Employee::getAge)).get();

    }



    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder("Employees working at Cafe " + name + ":" + System.lineSeparator());
        for (Employee employee : employees) {
            builder.append(employee.toString())
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();



    }

    public boolean removeEmployee(String name) {
        return employees.removeIf(n -> n.getName().equals(name));
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(n -> n.getName().equals(name)).findFirst().get();
    }
}

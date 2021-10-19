package cafe;

public class Employee {
    private final String name;
    private final int age;
    private final String country;

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, %d from %s", this.name, this.age, this.country);
    }
}

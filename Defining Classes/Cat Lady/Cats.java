package CatLady;

public class Cats {
    private String breed;
    private String name;
    private double characteristic;


    public Cats(String breed,String name, double characteristic) {
        this.breed = breed;
        this.name = name;
        this.characteristic = characteristic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", breed, name, characteristic);
    }
}

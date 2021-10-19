package rabbits;

public class Rabbit {
    private String name;
    private String species;
    private boolean available;

    public Rabbit(String name, String species) {
        this.name = name;
        this.species = species;
        this.available = true;
    }
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable() {
        this.available = false;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return String.format("Rabbit (%s): %s", species, name);
    }
}

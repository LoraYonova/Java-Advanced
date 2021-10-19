package guild;



public class Player {
    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(String.format("Player %s: %s", name, clazz));
        builder.append(System.lineSeparator());
        builder.append(String.format("Rank: %s", rank));
        builder.append(System.lineSeparator());
        builder.append(String.format("Description: %s", description));
        builder.append(System.lineSeparator());

        return builder.toString().trim();
    }


}

package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (capacity > roster.size()) {
            roster.add(player);
        }
    }

    public int count() {
        return roster.size();
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(n -> n.getName().equals(name));
    }

    public void promotePlayer(String name) {
        roster.stream().filter(n -> n.getName().equals(name)).findFirst().get().setRank("Member");
    }

    public void demotePlayer(String name) {
        roster.stream().filter(n -> n.getName().equals(name)).findFirst().get().setRank("Trial");
    }



    public Player[] kickPlayersByClass(String clazz) {
        Player[] names = roster.stream().filter(c -> c.getClazz().equals(clazz)).toArray(Player[]::new);
        roster.removeAll(List.of(names));
        return names;
    }

    public String report() {
        StringBuilder builder = new StringBuilder(String.format("Players in the guild: %s:", name));
        builder.append(System.lineSeparator());
        for (Player player : roster) {
            builder.append(player);
            builder.append(System.lineSeparator());

        }
        return builder.toString().trim();
    }
}

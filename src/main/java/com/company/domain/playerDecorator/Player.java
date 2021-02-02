package com.company.domain.playerDecorator;

import java.util.Objects;

public class Player extends PersonDecorator {
    transient private static final long serialVersionUID = 17L;
    private final long id;
    private final int height;
    private final String position;
    private final String level;

    public Player() {
        this(new DefinedPerson(), 0, "", "", 0);
    }

    public Player(Person person) {
        this(person, 190, "setter", "master", 0);
    }

    public Player(Person person, int height, String position, String level, long id) {
        super(person);
        this.id = id;
        this.height = height;
        this.position = position;
        this.level = level;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getYearOfBirth() {
        return super.getYearOfBirth();
    }

    public int getHeight() {
        return height;
    }

    public String getPosition() {
        return position;
    }

    public String getLevel() {
        return level;
    }

    public long personID() {
        return super.getID();
    }

    @Override
    public long getID() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return height == player.height &&
                Objects.equals(position, player.position) &&
                Objects.equals(level, player.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, position, level);
    }

    @Override
    public String toString() {
        return "Player{" + " id: " + id + ", name " +
                getName() + " year of Birth: "
                + getYearOfBirth() +
                "height=" + height +
                ", position='" + position + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

}

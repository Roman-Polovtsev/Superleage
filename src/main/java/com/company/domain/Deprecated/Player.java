package com.company.domain.Deprecated;

import java.beans.Transient;
import java.util.Objects;

public class Player extends Person {
    private final String level;
    private final String position;
    private final int height;

    public Player() {
        this("Ivan Ivanov");
    }

    public Player(long ID) {
        this("name", 1995, ID, "amateur", "not stated", 175);
    }

    public Player(int height, int year){
        this("unnamed",year,1,"not stated","not stated",height);
    }
    public Player(String name) {
        this(name, 1990);
    }

    public Player(int height) {
        this("", 1995, 1, "", "", height);
    }

    public Player(String name, int year) {
        this(name, year, 1, "amateur", "not stated", 175);
    }

    public Player(String name, int yearOfBirth, long ID, String level, String position, int height) {
        super(name, yearOfBirth, ID);
        this.level = level;
        this.position = position;
        this.height = height;
    }

    @Transient
    public long getId() {
        return hashCode();
    }

    public String getLevel() {
        return level;
    }

    public String getPosition() {
        return position;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getYearOfBirth() {
        return super.getYearOfBirth();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return " " + super.getName() + "\n Year of Birth: " + super.getYearOfBirth() +
                "\n level: " + level +
                "\n position: " + position +
                "\n height: " + height + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return height == player.height &&
                Objects.equals(level, player.level) &&
                Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), level, position, height);
    }
}

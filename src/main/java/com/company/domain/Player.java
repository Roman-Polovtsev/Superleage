package com.company.domain;

import java.time.Year;
import java.util.Objects;

public class Player extends Person {
    private final String level;
    private final String position;
    private final int height;

    public Player(){
        this("Ivan Ivanov");
    }

    public Player(String name){
        this(name,1990);
    }

    public Player(String name, int year){
        super(name,year);
        this.level = "amateur";
        this.position = "not stated";
        this.height = 0;
    }

    public Player(String name, int yearOfBirth, String level, String position, int height) {
        super(name, yearOfBirth);
        this.level = level;
        this.position = position;
        this.height = height;
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
        return  " " + super.getName() + "\n Year of Birth: "+ super.getYearOfBirth() +
                "\n level: " + level +
                "\n position: " + position  +
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

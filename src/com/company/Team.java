package com.company;

import java.util.Objects;

public class Team {
    private final Hall hall;
    private final String name;

    public Team() {
        this("");
    }

    public Team(String name) {
        this(null, name);
    }

    public Team(Hall hall, String name) {
        this.hall = hall;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Hall getHall() {
        return hall;
    }

    @Override
    public String toString(){
        return name + " " + hall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(hall, team.hall) &&
                Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hall, name);
    }
}

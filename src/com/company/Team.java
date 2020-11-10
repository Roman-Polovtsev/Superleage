package com.company;

import java.util.Objects;
import java.util.Set;

public class Team {
    private final Hall hall;
    private final String name;
    private Player captain;
    private Set <? extends Person> members;

    public Team() {
        this("unnamed");
    }

    public Team(String name) {

       // this(null, name);
        this(new Hall(), name);
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

        return "Team \"" + name + "\" information:\n\t"  + hall;
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

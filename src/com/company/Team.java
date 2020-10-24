package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Team {
    private Hall hall;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        Main.addTeamName(this,name);
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
        Main.addTeamHall(this,hall);
    }


}

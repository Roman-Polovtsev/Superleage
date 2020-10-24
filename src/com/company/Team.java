package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Team {
    static private Set<String> name = new HashSet<String>();
    private Map<String, Hall> mapHall = new HashMap<String, Hall>()
    private Hall hall;

    public Team(String nameOfTeam, Hall hall) {
      //  this.name = name;
        name.add(nameOfTeam);
        Main.addTeamHall.put(this, hall);
    }

    static public void show (){
        for (String item:name){
            System.out.println(item);
        }
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    public Hall getHall() {
//        return hall;
//    }
//
//    public void setHall(Hall hall) {
//        this.hall = hall;
//    }
//
//
}

package com.company.domain;

import java.io.Serializable;
import java.time.Year;
import java.util.*;

public class Team implements Serializable  {
     private static final long serialVersionUID = 1L;
     private final Hall hall;
     private final String name;
     private Captain captain;
     private final Set <Player> members;
    transient private float averageHeight;
    transient private float averageAge;

    public Team() {
        this("unnamed");
    }

    public Team(String name) {
        this(new Hall(), name);
    }

    public Team(Hall hall, String name) {
        this.hall = hall;
        this.name = name;
        this.members = new HashSet<>();
        this.captain = null;
        this.averageHeight = averageHeight();
        this.averageAge = setAverageAge();
    }

    public String getName() {
        return name;
    }

    public Hall getHall() {
        return hall;
    }

    public boolean addPlayer(Player player){
        if (members.add(player)) {
            this.averageAge = setAverageAge();
            this.averageHeight = averageHeight();
            return true;
        }
        else return false;
    }

    public boolean addPlayer (List<Player> playerList){
        if (members.addAll(playerList)) {
            this.averageAge = setAverageAge();
            this.averageHeight = averageHeight();
            return true;
        } else return false;
    }

    public boolean deletePlayer (Player player){
        boolean remove = members.remove(player);
        averageHeight = averageHeight();
        averageAge = setAverageAge();
        return remove;
    }

    public float getAverageHeight() {
        return averageHeight;
    }

    public float getAverageAge() {
        return averageAge;
    }

    public Set<Player> getMembers() {
        return members;
    }

    public Captain getCaptain() {
        return captain;
    }
    
    public void setCaptain (String number, String email){
        if (members.isEmpty()) throw new NullPointerException("There's no players in team to set captain");
        else {
            Set<Player> members = this.getMembers();
            Player captain = members.iterator().next();
            this.captain = new Captain(captain, number,email);
        }
    }

    public void setCaptain (){
        if (members.isEmpty()) throw new NullPointerException("There's no players in team to set captain");
        else {
            Set<Player> members = this.getMembers();
            Player captain = members.iterator().next();
            this.captain = new Captain(captain);
        }
    }

    @Override
    public String toString(){

        return "Team \"" + name + "\" information:\n\t"  + hall + "\n" + captain;
    }


    public float averageHeight() {
        float averageHeight;
        int height = 0;
        if (members.isEmpty()) return 0;
        else {
            for (Player player : members)
                height = height + player.getHeight();
            return averageHeight = ((float) height) / ((float) members.size());
        }
    }

    public float setAverageAge(){
        if (members.isEmpty()) return 0;
        else{
            Year currentYear = Year.now();
            float averageAge = 0;
            for (Player player : members)
               averageAge += currentYear.getValue() - player.getYearOfBirth();
            return (float)averageAge/members.size();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(hall, team.hall) &&
                Objects.equals(name, team.name) &&
                Objects.equals(captain, team.captain) &&
                Objects.equals(members, team.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hall, name, captain, members);
    }
}

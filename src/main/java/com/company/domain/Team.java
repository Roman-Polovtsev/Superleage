package com.company.domain;

import java.io.Serializable;
import java.time.Year;
import java.util.*;

public class Team implements Serializable {
    private static final long serialVersionUID = 1L;
    private final long ID;
    private final Hall hall;
    private final String name;
    private Captain captain;
    private final Set<Player> members;
    transient private float averageHeight;
    transient private float averageAge;

    public Team() {
        this("unnamed");
    }

    public Team(String name, long ID) {
        this(new Hall(), name, ID, null);
    }

    public Team(String name) {
        this(new Hall(), name, serialVersionUID, null);
    }

    public Team(long ID) {
        this(new Hall(), "unnamed", ID, null);
    }

    public Team(Hall hall, String name, long ID,  Captain captain) {
        this.ID = ID;
        this.hall = hall;
        this.name = name;
        this.members = new HashSet<>();
        this.captain = captain;
        this.averageHeight = averageHeight();
        this.averageAge = setAverageAge();
    }

    public Team (Captain captain){
        this(new Hall(), "",1,captain);
    }

    public String getName() {
        return name;
    }

    public Hall getHall() {
        return hall;
    }

    public long getID() {
        return ID;
    }

    public void addPlayer(Player... players) {
        List<Player> players1 = Arrays.asList(players);
        members.addAll(players1);
        if (members.addAll(players1)) {
            this.averageAge = setAverageAge();
            this.averageHeight = averageHeight();
        }
    }

    public void addPlayer(List<Player> playerList) {
        if (members.addAll(playerList)) {
            this.averageAge = setAverageAge();
            this.averageHeight = averageHeight();
        }
    }

    public void deletePlayer(Player player) {
        members.remove(player);
        averageHeight = averageHeight();
        averageAge = setAverageAge();
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

    public void setCaptain(String number, String email) {
        if (members.isEmpty()) throw new NullPointerException("There's no players in team to set captain");
        else {
            Set<Player> members = this.getMembers();
            Player captain = members.iterator().next();
            this.captain = new Captain(captain, number, email);
        }
    }

    public void setCaptain() {
        if (members.isEmpty()) throw new NullPointerException("There's no players in team to set captain");
        else {
            Set<Player> members = this.getMembers();
            Player captain = members.iterator().next();
            this.captain = new Captain(captain);
        }
    }

    @Override
    public String toString() {

        return "Team \"" + name + "\" information:\n\t" + hall + "\n captain:" + captain + "\n members: " + this.getMembers();
    }


    private float averageHeight() {
        float averageHeight;
        int height = 0;
        if (members.isEmpty()) return 0;
        else {
            for (Player player : members)
                height = height + player.getHeight();
            return averageHeight = ((float) height) / ((float) members.size());
        }
    }

    private float setAverageAge() {
        if (members.isEmpty()) return 0;
        else {
            Year currentYear = Year.now();
            float averageAge = 0;
            for (Player player : members)
                averageAge += currentYear.getValue() - player.getYearOfBirth();
            return (float) averageAge / members.size();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return ID == team.ID &&
                Objects.equals(hall, team.hall) &&
                Objects.equals(name, team.name) &&
                Objects.equals(captain, team.captain) &&
                Objects.equals(members, team.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, hall, name, captain, members);
    }
}

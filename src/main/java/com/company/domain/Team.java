package com.company.domain;

import com.company.domain.PlayerDecorator.Captain;
import com.company.domain.PlayerDecorator.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.Year;
import java.util.*;

public class Team implements Serializable, IdHolders {
    private static final long serialVersionUID = 1L;
    public static long idCounter = 1;
    private final long ID;
    private final Hall hall;
    private final String name;
    private final Captain captain;
    private final Set<Player> members;

    public Team() {
        this("unnamed");
    }

    public Team(String name) {
        this(LoggerFactory.getLogger(Team.class), new Hall(), name, new Captain(new Player(), "", ""));
    }

    public Team(Logger logger, Hall hall, String name, Captain captain) {
        this.ID = idCounter;
        this.hall = hall;
        this.name = name;
        this.members = new HashSet<>();
        members.add(captain.getCaptainAsPlayer());
        this.captain = captain;
        idCounter++;
    }

    public String getName() {
        return name;
    }

    public Hall getHall() {
        return hall;
    }

    @Override
    public long getID() {
        return ID;
    }

    public void addPlayer(Player... players) {
        List<Player> players1 = Arrays.asList(players);
        members.addAll(players1);
    }

    public void addPlayer(List<Player> playerList) {
        members.addAll(playerList);
    }

    public void deletePlayer(Player... player) {
        members.remove(player);
    }

    public void deletePlayer(List<Player> players) {
        members.removeAll(players);
    }

    public float getAverageHeight() {
        if (members.isEmpty()) {
            return 0;
        } else {
            int sumHeight = members.stream().mapToInt(Player::getHeight).sum();
            return (float) sumHeight / ((float) members.size());
        }
    }

    public float getAverageAge() {
        int currentYear = Year.now().getValue();
        if (members.isEmpty())
            return 0;
        else {
            int sumAge = members.stream().mapToInt(player -> (currentYear - player.getYearOfBirth())).sum();
            return (float) sumAge / ((float) members.size());
        }
    }

    public Set<Player> getMembers() {
        return members;
    }

    public Captain getCaptain() {
        return captain;
    }
// TODO: 14.01.2021  implement set/change captain methods at service level,


    @Override
    public String toString() {
        return "Team \"" + name + "\" information:\n\t" + hall + "\n captain:" + captain + "\n members: " + this.getMembers();
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

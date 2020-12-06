package com.company.domain;

import java.util.*;

public class Table {
    private final Set<Team> teams;
    private final List<Team> ranking;
    private Map<Team,Integer> teamPoints;

    Table(){
        this.teams = new HashSet<>();
        this.ranking = new LinkedList<>();
        this.teamPoints = new HashMap<>();
        for (Team team: teams
             ) {
            teamPoints.put(team,0);
        }
    }

    Table(Set<Team> teams){
        this.teams = teams;
        ranking = new LinkedList<>();
        ranking.addAll(teams);
        this.teamPoints = new HashMap<>();
        for (Team team : teams
             ) {
            teamPoints.put(team,0);
        }

    }

    public void addTeam(Team team){
        teams.add(team);
    }

    public void addGame (Game game){
        byte [] score = new byte [] {game.getGameResult().getHomeScore(),game.getGameResult().getGuestScore()};
        switch (score[0]){
            case (3) : {
                if (score[1] == 2) {
                    teamPoints.put(game.getHome(), teamPoints.get(game.getHome()) + 2);
                    teamPoints.put(game.getGuest(),teamPoints.get(game.getGuest()) + 1);
                    break;
                }
                else
                    teamPoints.put(game.getHome(), teamPoints.get(game.getHome()) + 3);
                break;
            }
            case (2) : {
                teamPoints.put(game.getHome(),teamPoints.get(game.getHome()) + 1);
                teamPoints.put(game.getGuest(),teamPoints.get(game.getGuest())+ 2);
                break;
            }
            case (0) :
                teamPoints.put(game.getGuest(),teamPoints.get(game.getGuest()) + 3);
                break;

        }

    }
}

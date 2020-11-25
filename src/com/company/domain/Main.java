package com.company.domain;


import com.company.repository.person.DbPersonRepository;
import com.company.repository.person.FilePersonRepository;
import com.company.repository.person.PersonRepository;

import java.time.DayOfWeek;
import java.util.*;

public class Main {





    public void testEnableGameTime() {
        EnableGameTime gameTime1 = new EnableGameTime();
        System.out.println(gameTime1);
        gameTime1.addDayOfWeek(DayOfWeek.MONDAY);
        gameTime1.addDayOfWeek(DayOfWeek.SUNDAY);
        System.out.println(gameTime1);

        List<DayOfWeek> days2 = new ArrayList<>();
        for (int day = 2; day < 4; day++)
            days2.add(DayOfWeek.of(day));
        System.out.println(days2.toString());
        EnableGameTime gameTime2 = new EnableGameTime(days2);
        System.out.println(gameTime2);
        gameTime2.addDayOfWeek(DayOfWeek.THURSDAY);
        System.out.println(gameTime2);

        EnableGameTime gameTime3 = new EnableGameTime();
        System.out.println(gameTime3);
    }

    private void testHall() {
        // Address address = new Address();
        // EnableGameTime gameTime = new EnableGameTime();
        Hall hall = new Hall();
        // System.out.println(hall);
        hall.print();
        // System.out.println(hall.print());

        //    System.out.println(hall);


    }

    private void testTeam() {
        Team team1 = new Team();
        System.out.println(team1);
    }

    public void testSchedule() {
        Schedule schedule1 = new Schedule();
        // System.out.println(schedule1);
        // schedule1.setGameResult(3,1);
        // System.out.println(schedule1);
        schedule1.setGameTime();
        System.out.println(schedule1);
    }

    public void testGame() {
        StartedGame game1 = new StartedGame();
        // System.out.println(schedule1);
        // schedule1.setGameResult(3,1);
        // System.out.println(schedule1);
        game1.getHome().getHall().getGameTime().addDayOfWeek(DayOfWeek.MONDAY);
        game1.getHome().getHall().getGameTime().addDayOfWeek(DayOfWeek.THURSDAY);
        System.out.println(game1);
    }


    public void testPlayer() {
        Player play1 = new Player();
        Player play2 = new Player("abc", 1995, "KMS", "middle blocker", 202);
        Team team1 = new Team();
        team1.setCaptain();
        team1.addPlayer(play1);
        System.out.println(team1.average());
        Player play3 = new Player("", 1998, "", "", 213);
        List<Player> list1 = new ArrayList();
        list1.add(play3);
        list1.add(play2);
        System.out.println(team1.addPlayer(list1));
        System.out.println(team1.average());
        System.out.println(team1.setAverageAge());
        // System.out.println(team1.addPlayer(play2));
        // System.out.println(team1.getMembers() );
        System.out.println(team1.getAverageAge());
        System.out.println(team1.getAverageHeight());
        Player newPlay = new Player("unnamed", 1953, "amateur", "setter", 170);
        team1.addPlayer(newPlay);
        System.out.println(team1.getAverageAge());
        System.out.println(team1.getAverageHeight());
        System.out.println(team1.deletePlayer(play1));
        System.out.println(team1.getAverageAge());
        System.out.println(team1.getAverageHeight());
        team1.setCaptain();
        System.out.println(team1.getCaptain());
    }

    public void testReferee() {
        Team team1 = new Team();
        Team team2 = new Team();
        StartedGame game1 = new StartedGame(team1, team2);
        Referee ref1 = new Referee();
        // float average = ref1.average();
        //System.out.println(average);
        Result result = new Result();
        System.out.println(game1.getGameAddress());
        System.out.println(game1.getGameReferee());
        System.out.println(game1.getGameResult());
        System.out.println(game1.getGameTime());
        System.out.println(game1.getRefereeMarks());
        System.out.println(ref1.average());
        //    Set<Game> games = game1.getGameReferee().getGames();
        //   System.out.println(games);
        //  System.out.println(game1.getGameReferee().getMarks(game1));
    }


    public static void main(String[] args) {
        PersonRepository repo = new DbPersonRepository();

        repo.save(new Person());
    }
}


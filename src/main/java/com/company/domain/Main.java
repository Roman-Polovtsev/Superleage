package com.company.domain;


import com.company.repository.person.DbPersonRepository;
import com.company.repository.person.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DayOfWeek;
import java.util.*;

public class Main {

   Logger logger = LoggerFactory.getLogger(Main.class);



    public void testEnableGameTime() {
        EnableGameTime gameTime1 = new EnableGameTime();
        logger.info("{}",gameTime1);
        gameTime1.addDayOfWeek(DayOfWeek.MONDAY);
        gameTime1.addDayOfWeek(DayOfWeek.SUNDAY);
        logger.info("{}",gameTime1);

        List<DayOfWeek> days2 = new ArrayList<>();
        for (int day = 2; day < 4; day++)
            days2.add(DayOfWeek.of(day));
        logger.info("{}",days2.toString());
        EnableGameTime gameTime2 = new EnableGameTime(days2);
        logger.info("{}",gameTime2);
        gameTime2.addDayOfWeek(DayOfWeek.THURSDAY);
        logger.info("{}",gameTime2);

        EnableGameTime gameTime3 = new EnableGameTime();
        logger.info("{}",gameTime3);
    }

    private void testHall() {
        // Address address = new Address();
        // EnableGameTime gameTime = new EnableGameTime();
        Hall hall = new Hall();
        // logger.info("{}",hall);
        hall.print();
        // logger.info("{}",hall.print());

        //    logger.info("{}",hall);


    }

    private void testTeam() {
        Team team1 = new Team();
        logger.info("{}",team1);
    }

    public void testSchedule() {
        Schedule schedule1 = new Schedule();
        // logger.info("{}",schedule1);
        // schedule1.setGameResult(3,1);
        // logger.info("{}",schedule1);
        schedule1.setGameTime();
        logger.info("{}",schedule1);
    }

    public void testGame() {
        StartedGame game1 = new StartedGame();
        // logger.info("{}",schedule1);
        // schedule1.setGameResult(3,1);
        // logger.info("{}",schedule1);
        game1.getHome().getHall().getGameTime().addDayOfWeek(DayOfWeek.MONDAY);
        game1.getHome().getHall().getGameTime().addDayOfWeek(DayOfWeek.THURSDAY);
        logger.info("{}",game1);
    }


    public void testPlayer() {
        Player play1 = new Player();
        Player play2 = new Player("abc", 1995, "KMS", "middle blocker", 202);
        Team team1 = new Team();
        team1.setCaptain();
        team1.addPlayer(play1);
        logger.info("{}",team1.averageHeight());
        Player play3 = new Player("", 1998, "", "", 213);
        List<Player> list1 = new ArrayList();
        list1.add(play3);
        list1.add(play2);
        logger.info("{}",team1.addPlayer(list1));
        logger.info("{}",team1.averageHeight());
        logger.info("{}",team1.setAverageAge());
        // logger.info("{}",team1.addPlayer(play2));
        // logger.info("{}",team1.getMembers() );
        logger.info("{}",team1.getAverageAge());
        logger.info("{}",team1.getAverageHeight());
        Player newPlay = new Player("unnamed", 1953, "amateur", "setter", 170);
        team1.addPlayer(newPlay);
        logger.info("{}",team1.getAverageAge());
        logger.info("{}",team1.getAverageHeight());
        logger.info("{}",team1.deletePlayer(play1));
        logger.info("{}",team1.getAverageAge());
        logger.info("{}",team1.getAverageHeight());
        team1.setCaptain();
        logger.info("{}",team1.getCaptain());
    }

    public void testReferee() {
        Team team1 = new Team();
        Team team2 = new Team();
        StartedGame game1 = new StartedGame(team1, team2);
        Referee ref1 = new Referee();
        // float average = ref1.average();
        //logger.info("{}",average);
        Result result = new Result();
        logger.info("{}",game1.getGameAddress());
        logger.info("{}",game1.getGameReferee());
        logger.info("{}",game1.getGameResult());
        logger.info("{}",game1.getGameTime());
        logger.info("{}",game1.getRefereeMarks());
        logger.info("{}",ref1.averageMark());
        //    Set<Game> games = game1.getGameReferee().getGames();
        //   logger.info("{}",games);
        //  logger.info("{}",game1.getGameReferee().getMarks(game1));
    }


    public static void main(String[] args) {
        PersonRepository repo = new DbPersonRepository();

        repo.save(new Person());
    }
}


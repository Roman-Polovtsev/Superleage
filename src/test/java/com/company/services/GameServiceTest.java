package com.company.services;

import com.company.domain.*;
import com.company.repository.Games.GamesRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

public class GameServiceTest {
    GamesRepository repository;
    GameService service;

    @Before
    public void beforeTests (){
        service = new GameService();
        repository = Mockito.mock(GamesRepository.class);
    }


    @Test
    public void createGame() {
        Team team1 = new Team();
        Team team2 = new Team("guest");
        Game game = new StartedGame();
        Mockito.doNothing().when(repository).save(game);

        service.createGame(team1,team2);

        Mockito.verify(repository,Mockito.times(1)).save(game);
    }

    @Test
    public void addGameResult() {
        Team team1 = new Team();
        Team team2 = new Team("guest");
        Schedule schedule = new Schedule(team1,team2);
        long id = schedule.getID();
        Game game = new StartedGame();
        Result result = new Result();
        Referee referee = new Referee();
        FinishedGame expected = new FinishedGame(game,result,referee);

        Mockito.doReturn(game).when(repository).getById(id);

        Game actual = service.addGameResult(game, result, referee);

        Assert.assertEquals(expected,actual);
        Mockito.verify(repository,Mockito.times(1)).getById(id);
        Mockito.verify(repository,Mockito.times(1)).save(actual);
    }
}
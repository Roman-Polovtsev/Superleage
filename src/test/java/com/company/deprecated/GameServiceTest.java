package com.company.deprecated;

import com.company.domain.GameDecorator.*;
import com.company.domain.PlayerDecorator.*;
import com.company.domain.Result;
import com.company.domain.Team;
import com.company.repository.Games.GamesRepository;
import com.company.services.GameService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GameServiceTest {
    GamesRepository repository;
    GameService service;

    @Before
    public void beforeTests() {
        service = new GameService();
        repository = Mockito.mock(GamesRepository.class);
    }


    @Test
    public void createGame() {
        Team team1 = new Team();
        Team team2 = new Team("guest");
        Game game = new PlannedGame();
        Mockito.doNothing().when(repository).save(game);

        service.createGame(team1, team2);

        Mockito.verify(repository, Mockito.times(1)).save(game);
    }

    @Test
    public void addGameResult() {
        Team team1 = new Team();
        Team team2 = new Team("guest");
        Game game = new PlannedGame();
        Result result = new Result();
        Referee referee = new Referee(new DefinedPerson());
        Game expected = new FinishedGame(game,result,referee,new int[]{5,5});

        //Mockito.doReturn(game).when(repository).getById(id);

        //Game actual = service.addGameResult(game, result, referee);

//        Assert.assertEquals(expected,actual);
//        Mockito.verify(repository,Mockito.times(1)).getById(id);
//        Mockito.verify(repository,Mockito.times(1)).save(actual);
    }
}
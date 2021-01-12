package com.company.services;

import com.company.domain.*;
import com.company.repository.Games.FileGameRepository;
import com.company.repository.Games.GamesRepository;

public class GameService {
    GamesRepository repository = new FileGameRepository();

    public void createGame (Team team1, Team team2){
        Schedule newGame = new Schedule(team1,team2);
        Game game = new StartedGame(team1,team2);
        repository.save(game);
    }

    public Game addGameResult(Game startedGame, Result result, Referee referee){
        Schedule schedule = new Schedule(startedGame.getHome(), startedGame.getGuest(), startedGame.getGameAddress(), result, referee);
        Game byId = repository.getById(schedule.getID());
        Game updatedGame = new FinishedGame(byId,result,referee);
        repository.save(updatedGame);
        return updatedGame;
    }
}

package com.company.domain.PlayerDecorator;

import com.company.domain.GameDecorator.FinishedGame;
import com.company.domain.GameDecorator.Game;

import java.util.*;

public class Referee extends PersonDecorator {
    private final List<Game> games;


    public Referee(AbstractPerson abstractPerson) {
        super(abstractPerson);
        this.games = new ArrayList<>();
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void addGame(Game... game) {
        List<Game> gamesToAdd = Arrays.asList(game);
        this.games.addAll(gamesToAdd);
    }

    public void deleteGame(Game game) {
        games.remove(game);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getYearOfBirth() {
        return super.getYearOfBirth();
    }

    public float getAverageMark() {
        List<int[]> marks = new ArrayList<>();
        games.forEach((game -> marks.add(game.getRefereeMarks())));
        double v = marks.stream().mapToDouble((int[] c) -> (float) Arrays.stream(c).sum() / c.length).average().orElseThrow();
        return (float) v;
    }

    public List<Game> getGames() {
        return games;
    }
}

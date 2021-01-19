package com.company.domain.PlayerDecorator;

import com.company.domain.GameDecorator.FinishedGame;
import com.company.domain.GameDecorator.Game;

import java.util.*;

public class Referee extends PersonDecorator {
    private final Set<FinishedGame> games;

    public Referee(AbstractPerson abstractPerson) {
        super(abstractPerson);
        this.games = new HashSet<>();
    }

    public void addGame(FinishedGame game) {
        games.add(game);
    }

    public void addGame(FinishedGame... game) {
        List<FinishedGame> gamesToAdd = Arrays.asList(game);
        this.games.addAll(gamesToAdd);
    }

    public void deleteGame(FinishedGame game) {
        games.remove(game);
    }

    public void deleteAllGames(){
        games.clear();
    }

    public void deleteGame(FinishedGame... games) {
        List<FinishedGame> gamesToRemove = Arrays.asList(games);
        this.games.removeAll(gamesToRemove);
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

    public Set<FinishedGame> getGames() {
        return games;
    }
}

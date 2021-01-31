package com.company.domain.PlayerDecorator;

import com.company.domain.GameDecorator.FinishedGame;

import java.util.*;

public class Referee extends PersonDecorator {
    transient private static final long serialVersionUID = 19L;
    private static long idCounter = 1;
    private final long id;
    private final Set<FinishedGame> games;

    public Referee(Person person) {
        super(person);
        this.id = idCounter;
        this.games = new HashSet<>();
        idCounter++;
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

    public void deleteAllGames() {
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

    @Override
    public long getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Referee{" +
                "games=" + games +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Referee referee = (Referee) o;
        return id == referee.id &&
                Objects.equals(games, referee.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, games);
    }
}

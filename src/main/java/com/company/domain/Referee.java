package com.company.domain;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Referee extends Person {
    private static final long serialVersionUID = 1L;
    private float averageMark;
    private final Map<FinishedGame, int[]> marksMap;

    public Referee() {
        super("John Doe", 1990);
        this.averageMark = (float) 0;
        this.marksMap = new HashMap<>();
    }

    public Referee(String name) {
        super(name);
        this.marksMap = new HashMap<>();
    }

    public void addGame(FinishedGame game) {
        // int [] marksDefault = new int[2];
        marksMap.put(game, game.getRefereeMarks());
        averageMark();
    }

    public Set<FinishedGame> getGames() {
        return marksMap.keySet();
    }

    public int[] getMarks(StartedGame game) {
        return marksMap.get(game);
    }


    public float averageMark() {
        if (marksMap.isEmpty()) throw new NullPointerException("There`s nothing to average");
        else {
            Set<FinishedGame> startedGames = marksMap.keySet();

            AtomicInteger countGames = new AtomicInteger(0);
            AtomicInteger sum = new AtomicInteger();
            startedGames.forEach((game) -> {
                sum.set(game.getRefereeMarks()[0] + game.getRefereeMarks()[1]);
                countGames.incrementAndGet();
            });
            float averageMark = sum.floatValue() / (countGames.floatValue() * 2);
            this.averageMark = averageMark;
            return averageMark;

//            int sum = 0;
//            int gamesCnt = 0;
//            Set<StartedGame> games = marksMap.keySet();
//            for (StartedGame game : games) {
//                sum = game.getRefereeMarks()[0] + game.getRefereeMarks()[1];
//                gamesCnt++;
//            }
//            this.averageMark = (float) sum / ((float) gamesCnt * 2);
//            return (float) sum / ((float) gamesCnt * 2);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Referee referee = (Referee) o;
        return Float.compare(referee.averageMark, averageMark) == 0 &&
                marksMap.equals(referee.marksMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), averageMark, marksMap);
    }

    @Override
    public String toString() {
        return "Referee{" +
                "marksMap=" + marksMap +
                '}';
    }
}


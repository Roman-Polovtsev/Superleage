package com.company;

import java.util.*;

public class Referee extends Person implements Averagable{
    private float averageMark;
    private List<Schedule> gamesList;
    private Map<Schedule,int[]> marksMap;

    public Referee (){
        super("John Doe",1990);
        this.averageMark = (float)0;
        this.gamesList = new ArrayList<Schedule>();
        this.marksMap = new HashMap<>();
    }

    public Referee (Schedule game){
        this();
        gamesList.add(game);
        int [] marksDefault = new int[2];
       // marksDefault = {0,0};
        marksMap.put(game, marksDefault);
    }

    public void addGame (Schedule game){
        int [] marksDefault = new int[2];
        marksMap.put(game, marksDefault);
    }

    public Set<Schedule> getGames (){
        return marksMap.keySet();
    }

    public int[] getMarks (Schedule game) {
        return marksMap.get(game);
    }





    @Override
     public float average(){
        if (gamesList.isEmpty()) throw new NullPointerException("There`s nothing to average");
        else {
            int sum = 0;
            int gamesCnt = 0;
            for (Schedule game : gamesList ) {
                sum = game.getRefereeMarks()[0] + game.getRefereeMarks()[1];
                gamesCnt++;
            }
            return (float)sum/(float)gamesCnt;
            }
        }
    }


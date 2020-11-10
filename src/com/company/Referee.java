package com.company;

import java.util.ArrayList;
import java.util.List;

public class Referee extends Person implements Averagable{
    private float averageMark;
    private List<Schedule> gamesList;
    public Referee (){
        super("John Doe",1990);
        this.averageMark = (float)0;
        this.gamesList = new ArrayList<Schedule>();
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


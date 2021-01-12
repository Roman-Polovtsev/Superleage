package com.company.domain.GameDecorator;

import com.company.domain.Referee;
import com.company.domain.Result;
import com.company.domain.Team;

import java.util.Arrays;

public class Test {



    public static void main(String[] args) {
        Team home = new Team();
        Team guest = new Team("guest");
        Game game = new PlannedGame(home,guest,1);
        System.out.println(game);


        Result result = new Result((byte)3,(byte)0);
        Referee referee = new Referee();
        int[] marks = {5,5};
        Game updatedgame = new FinishedGame(game,result,referee,marks);
        System.out.println("\n"+updatedgame);

    }
}

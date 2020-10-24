package com.company;

public class Result {
    private byte homeTeam;
    private byte guestTeam;
    
    //making constructor
    Result(byte homeTeam, byte guestTeam , Team home, Team guest){
      this.homeTeam = homeTeam;
      this.guestTeam = guestTeam;
      Main.addResult( this );
    }

    public Result getResult(Team home, Team guest){
        return Result;
    }

    public String getScore (Team home, Team guest){
        Result
    }


}

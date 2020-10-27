package com.company;

public class Result {
    private final byte homeTeam;
    private final byte guestTeam;
    
    //making constructor
    public Result (){
        this((byte)0,(byte)0);
    }

    public Result(byte homeTeam, byte guestTeam ){
      this.homeTeam = homeTeam;
      this.guestTeam = guestTeam;
    }

    @Override
    public String toString() {
        return "Result" +
                " " + homeTeam +
                ":" + guestTeam;
    }

    public byte getHomeScore(){
        return homeTeam;
    }

    public byte getGuestScore(){
        return guestTeam;
    }


}

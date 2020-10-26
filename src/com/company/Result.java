package com.company;

public class Result {
    private final byte  homeTeam;
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
        return "Результат игры" +
                " " + homeTeam +
                ": " + guestTeam;
    }

    public byte getHomescore(){
        return homeTeam;
    }

    public byte getGuestScore(){
        return guestTeam;
    }


}

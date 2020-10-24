package com.company;

public class Result {
    private byte homeTeam;
    private byte guestTeam;
    
    //making constructor
    public Result(byte homeTeam, byte guestTeam ){
      this.homeTeam = homeTeam;
      this.guestTeam = guestTeam;
    }


    public byte getHomescore(){
        return homeTeam;
    }

    public byte getGuestScore(){
        return guestTeam;
    }


}

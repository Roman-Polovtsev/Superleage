package com.company;

public class Result {
    byte homeTeam;
    byte guestTeam;
    
    //making constructor
    Result(byte homeTeam, byte guestTeam ){
      this.homeTeam = homeTeam;
      this.guestTeam = guestTeam;
    }

    public String toString(){
        return homeTeam + ":" + guestTeam;
    } 
    

    public String show () {
        String result = homeTeam + ":" + guestTeam;
        return result;
    }
}

package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Set<Address> addrList = new HashSet<Address>();
    private static Map<Hall,Address> hallAddrMap = new HashMap<Hall, Address>();
    private static Map<Team, Hall> teamHallMap = new HashMap<Team, Hall>();
    private static Map<Schedule, Result> scheduleResultMap = new HashMap<Schedule, Result>();
    private static Set<Result> resultList = new HashSet<Result>();

    public static void addAddr(Address newAddr){
        addrList.add(newAddr);
    };

    public static void addHallAddr(Hall hall, Address addr){
        hallAddrMap.put(hall,addr);
    };

    public static Address getHallAddr(Hall hall){
        return hallAddrMap.get(hall);
    };

    public void addTeamHall ( Team team, Hall hall){
        teamHallMap.put(team,hall);
    };

    public  Hall getTeamHall ( Team team){
        return teamHallMap.get(team);
    };

    public static void addScheduleResultMap(Schedule schedule, Result result){
        scheduleResultMap.put(schedule, result);
    }

    public Result getScheduleResultMap (Schedule schedule){
        return scheduleResultMap.get(schedule);
    }

    public Result getScheduleResultMap (Schedule schedule){
        return scheduleResultMap.get(schedule);
    }

    public static void addResult(Result result){
        resultList.add(result);
    }

    public Result getResult (Result result){
        resultList.get(result);
    }

    public static void main(String[] args) {


        Address addr1 = new Address("spb","petrovsky","27");
        Address addr2 = new Address("spb","nevsky","135 C");

        Hall hall1 = new Hall ( addr1 );
        Hall hall2 = new Hall ( addr2 );

        Team lmgt = new Team("lmgt", hall1 );
        Team lenenergo = new Team("lenenergo", hall2);

        Schedule lmgtLenenergo = new Schedule ( lmgt, lenenergo );

        Result lmgtLenenergoRes = new Result ( 3,0,lmgt, lenenergo ); 

        Schedule.getResult(lmgtLenenergo);
        System.out.println(item);

        


    }
}


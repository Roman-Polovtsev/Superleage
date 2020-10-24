package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Set<Address> addrList = new HashSet<Address>();
    private static Map<Hall,Address> hallAddrMap = new HashMap<Hall, Address>();
    private static Map<Team, Hall> teamHallMap = new HashMap<Team, Hall>();
    private static Map<Team, String> teamNameMap = new HashMap<Team, String>();
    private static Map<Schedule, Result> scheduleResultMap = new HashMap<Schedule, Result>();
    private static Set<Result> resultSet = new HashSet<Result>();

    public static void addAddr(Address newAddr){
        addrList.add(newAddr);
    };

    public static void addHallAddr(Hall hall, Address addr){
        hallAddrMap.put(hall,addr);
    };

    public static Address getHallAddr(Hall hall){
        return hallAddrMap.get(hall);
    };

    public static void addTeamHall(Team team, Hall hall){
        teamHallMap.put(team,hall);
    };

    public static Result getGameResult(Schedule schedule) {
    }

    public  Hall getTeamHall ( Team team){
        return teamHallMap.get(team);
    };
    public static void addTeamName(Team team, String name){
        teamNameMap.put(team,name);
    };

    public  String getTeamName ( Team team){
        return teamNameMap.get(team);
    };
    public static void addScheduleResultMap(Schedule schedule, Result result){
        scheduleResultMap.put(schedule, result);
    }



    public static void addResult(Result result){
        resultSet.add(result);
    }


    public static void main(String[] args) {

        Result res30 = new Result(3,0);
        Result res31 = new Result(3,1);
        Result res32 = new Result(3,2);
        Result res03 = new Result(0,3);
        Result res13 = new Result(1,3);
        Result res23 = new Result(2,3);
        Main.addResult(res30);
        Main.addResult(res31);
        Main.addResult(res32);
        Main.addResult(res03);
        Main.addResult(res13);
        Main.addResult(res23);

        Address addr1 = new Address("spb","petrovsky","27");
        Address addr2 = new Address("spb","nevsky","135 C");

        Hall hall1 = new Hall ( addr1 );
        Hall hall2 = new Hall ( addr2 );

        Team lmgt = new Team;//("lmgt", hall1 );
        Team lenenergo = new Team;//("lenenergo", hall2);

        Schedule lmgtLenenergo = new Schedule ( lmgt, lenenergo );

       // Result lmgtLenenergoRes = new Result ( 3,0);

        lmgtLenenergo.getGameResult();
        System.out.println(item);

        


    }
}


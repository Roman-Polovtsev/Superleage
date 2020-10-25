package com.company;

import javax.crypto.Mac;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Main {
    private static Set<Address> addrList = new HashSet<Address>();
    private static Map<Hall, Address> hallAddrMap = new HashMap<Hall, Address>();
    private static Map<Team, Hall> teamHallMap = new HashMap<Team, Hall>();
    private static Map<Team, String> teamNameMap = new HashMap<Team, String>();
    private static Map<Schedule, Result> scheduleResultMap = new HashMap<Schedule, Result>();
    private static Set<Result> resultSet = new HashSet<Result>();
    //Admin methods

    public static void addAddr(Address newAddr) {
        addrList.add(newAddr);
    }

    ;

    public static void addHallAddr(Hall hall, Address addr) {
        hallAddrMap.put(hall, addr);
    }

    ;

    public static void addTeamHall(Team team, Hall hall) {
        teamHallMap.put(team, hall);
    }

    ;

    public static void addTeamName(Team team, String name) {
        teamNameMap.put(team, name);
    }

    ;

    //Service methods

    public static Address getHallAddr(Hall hall) {
        return hallAddrMap.get(hall);
    }

    ;


//    public static Result getGameResult(Schedule schedule) {
//    }

    public Hall getTeamHall(Team team) {
        return teamHallMap.get(team);
    }

    ;


    public String getTeamName(Team team) {
        return teamNameMap.get(team);
    }

    ;

    public static void addScheduleResultMap(Schedule schedule, Result result) {
        scheduleResultMap.put(schedule, result);
    }


    public static void addResult(Result result) {
        resultSet.add(result);
    }

    //Users methods
    static void showGameInfo(Team teamHome, Team teamGuest) {
        if (Schedule.getSchedule(teamHome, teamGuest) != null)//(teamHome.getName() == null) || (teamGuest.getName() == null))
            System.out.println("Игра между командой " + teamHome.getName() + " и командой " + teamGuest.getName() + " пройдет по адресу: " + teamHome.getHall().getAddress().toString());
        else
            System.out.println("Информация об игре не найдена!");
    }


    public void startProgram() {
        Team first = new Team("fisrt");
        Team second = new Team("second");
        Team third = new Team("third");
        DataSource DB = new DataSource();

        Schedule monday = new Schedule(first, second);
        Schedule sunday = new Schedule(second, third);
        DB.save(monday);
        DB.save(sunday);

        Schedule schedule = DB.getSchedule(first, new Team("second"));
        if (schedule == null)
            System.out.println("Schedule not found");
        else
            System.out.println(schedule);
    }


    private void testList() {
        int number = 10_000_000;
        List<Integer> integers = new LinkedList<>();
        for (int i = 0; i < number; i++) {
            integers.add(i, new Random().nextInt());
        }
        integers.remove(5_345_525);
        integers.remove(6_345_525);
        integers.remove(8_748_225);
    }

    //arrayList = 749 | 858
    //linkedList = 2376 | 2758

    public static void main(String[] args) {
        Main object = new Main();
        long start = System.currentTimeMillis();
        object.testList();
        long end = System.currentTimeMillis();
        System.out.println("Test time: " + (end - start) + " ms");

//        Result res30 = new Result((byte) 3, (byte) 0);
//        Result res31 = new Result((byte) 3, (byte) 1);
//        Result res32 = new Result((byte) 3, (byte) 2);
//        Result res03 = new Result((byte) 0, (byte) 3);
//        Result res13 = new Result((byte) 1, (byte) 3);
//        Result res23 = new Result((byte) 2, (byte) 3);
//        Main.addResult(res30);
//        Main.addResult(res31);
//        Main.addResult(res32);
//        Main.addResult(res03);
//        Main.addResult(res13);
//        Main.addResult(res23);
//
//        Address addr1 = new Address("spb", "petrovsky", "27");
//        Address addr2 = new Address("spb", "nevsky", "135 C");
//
//        Hall hall1 = new Hall();
//        hall1.setAddress(addr1);
//
//        Hall hall2 = new Hall();
//        hall2.setAddress(addr2);
//
//        Team lmgt = new Team();//("lmgt", hall1 );
//        lmgt.setHall(hall1);
//        lmgt.setName("Ленметрогипротранс");
//
//        Team lenenergo = new Team();//("lenenergo", hall2);
//        lenenergo.setName("Ленэнерго");
//        lenenergo.setHall(hall2);
//
//        Team abc = new Team();
//
//        EnableGameTime fri2022 = new EnableGameTime();
//
//        fri2022.setBegin(LocalTime.of(20, 0));
//        fri2022.setEnd(LocalTime.of(22, 0));
//        fri2022.setDaysOfWeek();
//
//        Schedule lmgtLenenergo = new Schedule(lmgt, lenenergo);
//
//        showGameInfo(lmgt, lenenergo);
//        showGameInfo(abc, lmgt);
//        System.out.println(fri2022.getBegin());
//        System.out.println(LocalTime.of(20, 0));

        // Result lmgtLenenergoRes = new Result ( 3,0);


        // System.out.println((lmgtLenenergo.getGameAddress()).getCity() + " " + (lmgtLenenergo.getGameAddress()).getStreet() +  " " + (lmgtLenenergo.getGameAddress()).getBuildingNumber());


    }
}


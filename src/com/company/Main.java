package com.company;

import javax.crypto.Mac;
import javax.xml.crypto.Data;
import java.time.DayOfWeek;
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

    public void testEnableGameTime (){
        EnableGameTime gameTime1 = new EnableGameTime();
        System.out.println(gameTime1);
        gameTime1.addDayOfWeek(DayOfWeek.MONDAY);
        gameTime1.addDayOfWeek(DayOfWeek.SUNDAY);
        System.out.println(gameTime1);

        List<DayOfWeek> days2 = new ArrayList<>();
        for (int day= 2; day < 4 ; day++)
            days2.add(DayOfWeek.of(day));
        System.out.println(days2.toString());
        EnableGameTime gameTime2 = new EnableGameTime(days2);
        System.out.println(gameTime2);
        gameTime2.addDayOfWeek(DayOfWeek.THURSDAY);
        System.out.println(gameTime2);

        EnableGameTime gameTime3 = new EnableGameTime();
        System.out.println(gameTime3);
    }

    private void testHall (){
       // Address address = new Address();
       // EnableGameTime gameTime = new EnableGameTime();
        Hall hall = new Hall();
       // System.out.println(hall);
        hall.print();
       // System.out.println(hall.print());

    //    System.out.println(hall);


    }

    private void testTeam (){
        Team team1 = new Team();
        System.out.println(team1);
    }

    public void testSchedule (){
        Schedule schedule1 = new Schedule();
       // System.out.println(schedule1);
       // schedule1.setGameResult(3,1);
       // System.out.println(schedule1);
        schedule1.setGameTime();
        System.out.println(schedule1);
    }


    private List<Integer> testList() {
        int number = 10_000_000;
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            integers.add(i, new Random().nextInt());
        }
//        integers.remove(5_345_525);
//        integers.remove(6_345_525);
//        integers.remove(8_748_225);
        return integers;
    }

    private void getFromList (List<Integer> integers, int index ){
        integers.get(index);
    }

    private void removeFromList (List<Integer> integers, int index ){
        integers.remove(index);
    }

    private void addToList(List<Integer> integers, int index){
        integers.add(index,new Random().nextInt());
    }


    public static void main(String[] args) {
        Main object = new Main();
       // object.testEnableGameTime();
      //  object.testHall();
       // object.testTeam();
     //   object.testSchedule();



        //long start = System.nanoTime();
        List<Integer> testList = object.testList();
        long start = System.nanoTime();//currentTimeMillis();
        object.getFromList(testList,325612);
        long end = System.nanoTime();
        System.out.println("Test time: " + (end - start) + " ms");

        //synopsys   =  add       | remove      | get 1    | remove 1 |  add 1
        //arrayList  =  996501000 | 1063985300  |   29600  | 20971100 |  18861200
        //linkedList = 2461123300 | 2479292400  | 4217000  |  4064500 |   4409900


    }
}


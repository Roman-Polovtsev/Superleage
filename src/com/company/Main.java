package com.company;



import java.time.*;
import java.util.*;

public class Main {


    public void startProgram() {
        Team first = new Team("first");
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
        gameTime1.addDayOfWeek(DayOfWeek.MONDAY, DayOfWeek.FRIDAY);
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

    private Team testTeam (){
        Team team1 = new Team();
        System.out.println(team1);
        return team1;
    }

    public Schedule testSchedule (){
        Schedule schedule1 = new Schedule();

       // System.out.println(schedule1);
       // schedule1.setGameResult(3,1);
       // System.out.println(schedule1);

       //getting list of enable day of week
        List<DayOfWeek> enableDaysForGame; //= new ArrayList<DayOfWeek>();
        enableDaysForGame = schedule1.getHome().getHall().getGameTime().getDays();
        System.out.println(enableDaysForGame);
        schedule1.getHome().getHall().getGameTime().addDayOfWeek();
        System.out.println(enableDaysForGame);
        LocalDateTime tempDate =  LocalDateTime.now();

        // setting new date as temp.date goes to next day of week from list
        try {
            schedule1.setGameTime(tempDate, enableDaysForGame.get(0));
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException){
            System.out.println("You`re trying to set game in day that not supported");
            schedule1.getHome().getHall().getGameTime().addDayOfWeek(DayOfWeek.FRIDAY);
            System.out.println(enableDaysForGame);
        }
        System.out.println(schedule1.getGameTime());
        System.out.println(schedule1.getGameResult());

       try {
           System.out.println(schedule1);
       }
       catch (NullPointerException nullPointerException){
           schedule1.setGameTime(LocalDateTime.now(),DayOfWeek.MONDAY);
       }
       return schedule1;
    }

    private void scheduleCreating ( Schedule schedule ) {
        Address homeAddr = schedule.getHome().getHall().getAddress();
        schedule.setGameAddress( homeAddr );
        System.out.println(schedule);
    }

  //Method`s overloading
    private Schedule scheduleCreating ( Team home, Team guest ) {
        Schedule  schedule = new Schedule(home, guest);
        Address homeAddr = schedule.getHome().getHall().getAddress();
        schedule.setGameAddress( homeAddr );
        schedule.setGameTime(LocalDateTime.of(2020,10,30,1,2),DayOfWeek.MONDAY);
        System.out.println(schedule);
        return schedule;
    }

    public static void main(String[] args) {
        Main object = new Main();
        object.testEnableGameTime();
        object.testHall();
        Team home = object.testTeam();
        Team guest = object.testTeam();
        Schedule schedule = object.testSchedule();
        Schedule schedule1 = object.scheduleCreating( guest,home );
        System.out.println(schedule1);
        System.out.println(schedule);


    }
}


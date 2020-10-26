package com.company;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EnableGameTime {
    private LocalTime begin;
    private LocalTime end;
    private final List<DayOfWeek> daysOfWeek;

    public EnableGameTime (){
        this(LocalTime.MIDNIGHT, LocalTime.of(23,59), new ArrayList<DayOfWeek>());
    }

    public EnableGameTime (LocalTime begin, LocalTime end){
        this( begin, end, new ArrayList<DayOfWeek>() );
    }

    public EnableGameTime (List<DayOfWeek> daysOfWeek){
        this( LocalTime.MIDNIGHT, LocalTime.of(23,59),  daysOfWeek );
    }

    public EnableGameTime (LocalTime begin, LocalTime end, List<DayOfWeek> daysOfWeek){
        this.begin = begin;
        this.end = end;
        this.daysOfWeek = daysOfWeek;
    }

    @Override
    public String toString() {
        return "Игровое время по дням недели: "+  getDaysOfWeek() + " c " + begin.toString() + " до " + end.toString() ;
    }


    public void addDayOfWeek (DayOfWeek dayOfWeek){
          daysOfWeek.add(dayOfWeek);
    }


    public LocalTime getEnd() {
        return end;
    }

    public String getDaysOfWeek() {
        String days = "";
        int cnt_days = 0;
        if (daysOfWeek.isEmpty())
            return days = "not stated";
        else
           for ( DayOfWeek day : daysOfWeek) {
                   if ( cnt_days < daysOfWeek.size() - 1 )
                      days = days + " " + day.toString()+",";
                   else
                       days = days + " " + day.toString();
               cnt_days++;
           }
        return days;
    }

}

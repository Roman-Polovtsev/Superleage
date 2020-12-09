package com.company.domain;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnableGameTime implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public LocalTime getBegin(){
        return begin;
    }

    public List<DayOfWeek> getDays (){
        List<DayOfWeek> weekDaysForGame = new ArrayList<DayOfWeek>();
        for(DayOfWeek day : daysOfWeek)
            weekDaysForGame.add(day);
        return weekDaysForGame;
    }

    /*
    *
    *  Next method is bad cause it creates new string every time when you try to add to existing string anything
    * after such "adding" origin string garbaged by collector and for new string takes new memory
    * To avoid this is recommended to use stringBuilder class
    *
    *
    *
     */
//    public String getDaysOfWeek() {
//        String days = "";
//        int cnt_days = 0;
//        if (daysOfWeek.isEmpty())
//            return days = "not stated";
//        else
//           for ( DayOfWeek day : daysOfWeek) {
//                   if ( cnt_days < daysOfWeek.size() - 1 )
//                      days = days + " " + day.toString()+",";
//                   else
//                       days = days + " " + day.toString();
//               cnt_days++;
//           }
//        return days;
//    }


    public String getDaysOfWeek(){
        StringBuilder days = new StringBuilder();
        int cnt_days = 0;
        if (daysOfWeek.isEmpty())
            return days.append("not stated").toString();
        else
            for(DayOfWeek dayOfWeek : daysOfWeek){
                if ( cnt_days < daysOfWeek.size()-1)
                    days.append(" " + dayOfWeek.toString() + ",");
                else
                    days.append(" " + dayOfWeek.toString());
                cnt_days++;
            }
            return days.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnableGameTime that = (EnableGameTime) o;
        return Objects.equals(begin, that.begin) &&
                Objects.equals(end, that.end) &&
                Objects.equals(daysOfWeek, that.daysOfWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(begin, end, daysOfWeek);
    }
}

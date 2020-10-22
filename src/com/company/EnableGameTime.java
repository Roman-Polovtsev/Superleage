package com.company;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class EnableGameTime {
    private LocalTime begin;
    private LocalTime end;
    private List<DayOfWeek> daysOfWeek;

    public LocalTime getBegin() {
        return begin;
    }

    public void setBegin(LocalTime begin) {
        this.begin = begin;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public List<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<DayOfWeek> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }
}

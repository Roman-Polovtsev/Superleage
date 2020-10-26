package com.company;

import java.util.List;
import java.util.ArrayList;

public class DataSource {

    private final List<Schedule> schedules;

    public DataSource() {

        this(new ArrayList<Schedule>() );
    }

    public DataSource(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void save(Schedule schedule) {
        schedules.add(schedule);
    }

    public Schedule getSchedule(Team home, Team guest) {
        Schedule currentSchedule = null;
        for (Schedule item : schedules)
            if ((item.getHome().equals(home)) && (item.getGuest().equals(guest))) {
                currentSchedule = item;
                break;
            }
        return currentSchedule;
    }

}

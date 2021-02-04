package com.company.domain;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class EnableGameTimeTest {

    @Test
    public void getDayOfWeekTest() {
        DayOfWeek expected = DayOfWeek.TUESDAY;
        List<DayOfWeek> days = Collections.singletonList(expected);
        EnableGameTime enableGameTime = new EnableGameTime(1, days.get(0));

        DayOfWeek actual = enableGameTime.getDayOfWeek();

        assertEquals(expected,actual);
    }

    @Test
    public void getDaysOfWeekTestThrows() {
        DayOfWeek expected = DayOfWeek.MONDAY;

        EnableGameTime enableGameTime = new EnableGameTime();
        DayOfWeek actual = enableGameTime.getDayOfWeek();

        assertEquals(expected,actual);
    }
}
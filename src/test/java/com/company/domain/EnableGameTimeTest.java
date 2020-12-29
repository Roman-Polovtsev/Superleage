package com.company.domain;

import org.junit.Test;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class EnableGameTimeTest {

    @Test
    public void getDaysOfWeekTest() {
        List<DayOfWeek> days = Arrays.asList(DayOfWeek.TUESDAY);
        String s =days.toString();
        EnableGameTime enableGameTime = new EnableGameTime(days);

        String daysOfWeek = "[" + enableGameTime.getDaysOfWeek().trim() + "]";
        String daysOfWeek1 = enableGameTime.getDaysOfWeek();

        assertEquals(s,daysOfWeek);

    }
    @Test
    public void getDaysOfWeekTestThrows() {
        List<DayOfWeek> days = Arrays.asList();

        EnableGameTime enableGameTime = new EnableGameTime(days);

        assertThrows(NullPointerException.class, enableGameTime::getDaysOfWeek);

    }
}
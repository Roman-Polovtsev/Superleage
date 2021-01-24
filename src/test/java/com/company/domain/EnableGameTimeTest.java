package com.company.domain;

import org.junit.Test;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class EnableGameTimeTest {

    @Test
    public void getDaysOfWeekTest() {
        List<DayOfWeek> days = Collections.singletonList(DayOfWeek.TUESDAY);
        String s =days.toString();
        EnableGameTime enableGameTime = new EnableGameTime(1,days);

        String daysOfWeek = "[" + enableGameTime.getDaysOfWeek().trim() + "]";
        String daysOfWeek1 = enableGameTime.getDaysOfWeek();

        assertEquals(s,daysOfWeek);

    }
    @Test
    public void getDaysOfWeekTestThrows() {
        List<DayOfWeek> days = Collections.emptyList();

        EnableGameTime enableGameTime = new EnableGameTime(1,days);

        assertThrows(NullPointerException.class, enableGameTime::getDaysOfWeek);
    }
}
package com.company.domain;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class EnableGameTime implements Serializable {
    private static final long serialVersionUID = 1L;
    private final LocalTime begin;
    private final LocalTime end;
    private final List<DayOfWeek> daysOfWeek;

    public EnableGameTime() {
        this(LocalTime.MIDNIGHT, LocalTime.of(23, 59), new ArrayList<>());
    }

    public EnableGameTime(LocalTime begin, LocalTime end) {
        this(begin, end, new ArrayList<>());
    }

    public EnableGameTime(List<DayOfWeek> daysOfWeek) {
        this(LocalTime.MIDNIGHT, LocalTime.of(23, 59), daysOfWeek);
    }

    public EnableGameTime(LocalTime begin, LocalTime end, List<DayOfWeek> daysOfWeek) {
        this.begin = begin;
        this.end = end;
        this.daysOfWeek = daysOfWeek;
    }

    @Override
    public String toString() {
        return "Игровое время по дням недели: " + this.getDays() + " c " + begin.toString() + " до " + end.toString();
    }


    public void addDayOfWeek(DayOfWeek dayOfWeek) {
        daysOfWeek.add(dayOfWeek);
    }

    public LocalTime getEnd() {
        return end;
    }

    public LocalTime getBegin() {
        return begin;
    }

    public List<DayOfWeek> getDays() {
        return daysOfWeek;
    }

    public String getDaysOfWeek() throws NullPointerException {
        if (daysOfWeek.isEmpty()) {
            throw new NullPointerException("No days " + this);
        } else {
            StringBuilder days = new StringBuilder();
            AtomicInteger cntDays = new AtomicInteger(0);
            daysOfWeek.forEach((day) -> {
                if (cntDays.get() < daysOfWeek.size() - 1)
                    days.append(" ").append(day.toString()).append(",");
                else
                    days.append(" ").append(day.toString());
                cntDays.incrementAndGet();
            });
            return days.toString();
        }
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

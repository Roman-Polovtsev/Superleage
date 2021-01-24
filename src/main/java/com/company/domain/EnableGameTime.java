package com.company.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class EnableGameTime implements Serializable,IdHolders {
    transient private final Logger logger;
    private static final long serialVersionUID = 1L;
    private final long id;
    private final LocalTime begin;
    private final LocalTime end;
    private final List<DayOfWeek> daysOfWeek;

    public EnableGameTime() {
        this(LoggerFactory.getLogger(EnableGameTime.class),1, LocalTime.MIDNIGHT, LocalTime.of(23, 59), new ArrayList<>());
    }

    public EnableGameTime(long id,LocalTime begin, LocalTime end) {
        this(LoggerFactory.getLogger(EnableGameTime.class),id, begin, end, new ArrayList<>());
    }

    public EnableGameTime(long id, List<DayOfWeek> daysOfWeek) {
        this(LoggerFactory.getLogger(EnableGameTime.class),id, LocalTime.MIDNIGHT, LocalTime.of(23, 59), daysOfWeek);
    }

    public EnableGameTime(Logger logger,long id, LocalTime begin, LocalTime end, List<DayOfWeek> daysOfWeek) {
        this.logger = logger;
        this.id = id;
        this.begin = begin;
        this.end = end;
        this.daysOfWeek = daysOfWeek;
    }

    @Override
    public long getID() {
        return id;
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
        return id == that.id &&
                Objects.equals(logger, that.logger) &&
                Objects.equals(begin, that.begin) &&
                Objects.equals(end, that.end) &&
                Objects.equals(daysOfWeek, that.daysOfWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logger, id, begin, end, daysOfWeek);
    }
}

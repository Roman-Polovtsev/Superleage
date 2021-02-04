package com.company.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

public class EnableGameTime implements Serializable {
    transient private final Logger logger;
    private static final long serialVersionUID = 1L;
    private final long id;
    private final LocalTime begin;
    private final LocalTime end;
    private final DayOfWeek dayOfWeek;

    public EnableGameTime() {
        this(LoggerFactory.getLogger(EnableGameTime.class), 1, LocalTime.MIDNIGHT, LocalTime.of(23, 59), DayOfWeek.MONDAY);
    }

    public EnableGameTime(long id, LocalTime begin, LocalTime end) {
        this(LoggerFactory.getLogger(EnableGameTime.class), id, begin, end, DayOfWeek.MONDAY);
    }

    public EnableGameTime(long id, LocalTime begin, LocalTime end, DayOfWeek day) {
        this(LoggerFactory.getLogger(EnableGameTime.class), id, begin, end, day);
    }

    public EnableGameTime(long id, DayOfWeek dayOfWeek) {
        this(LoggerFactory.getLogger(EnableGameTime.class), id, LocalTime.MIDNIGHT, LocalTime.of(23, 59), dayOfWeek);
    }

    public EnableGameTime(Logger logger, long id, LocalTime begin, LocalTime end, DayOfWeek daysOfWeek) {
        this.logger = logger;
        this.id = id;
        this.begin = begin;
        this.end = end;
        this.dayOfWeek = daysOfWeek;
        logger.info("created new Game Time object");
    }

    public long getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Игровое время: " + this.getDayOfWeek() + " c " + begin.toString() + " до " + end.toString();
    }

    public LocalTime getEnd() {
        return end;
    }

    public LocalTime getBegin() {
        return begin;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

//    public List<DayOfWeek> getDays() {
//        return daysOfWeek;
//    }
//
//    public String getDaysOfWeek() throws NullPointerException {
//        if (daysOfWeek.isEmpty()) {
//            throw new NullPointerException("No days " + this);
//        } else {
//            StringBuilder days = new StringBuilder();
//            AtomicInteger cntDays = new AtomicInteger(0);
//            daysOfWeek.forEach((day) -> {
//                if (cntDays.get() < daysOfWeek.size() - 1)
//                    days.append(" ").append(day.toString()).append(",");
//                else
//                    days.append(" ").append(day.toString());
//                cntDays.incrementAndGet();
//            });
//            return days.toString();
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnableGameTime that = (EnableGameTime) o;
        return id == that.id &&
                Objects.equals(begin, that.begin) &&
                Objects.equals(end, that.end) &&
                dayOfWeek == that.dayOfWeek;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, begin, end, dayOfWeek);
    }
}

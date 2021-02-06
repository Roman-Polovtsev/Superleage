package com.company.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hall implements Serializable {
    transient private final Logger logger;
    transient private static final long serialVersionUID = 2L;
    private final long id;
    private final Address address;
    private final List<EnableGameTime> gameTimeList;

    public Hall() {
        this(LoggerFactory.getLogger(Hall.class), 1, new Address(), new ArrayList<>());
    }

    public Hall(long id, Address address) {
        this(LoggerFactory.getLogger(Hall.class), id, address, new ArrayList<>());
    }

    public Hall(long id, Address address, List<EnableGameTime> gameTimeList) {
        this(LoggerFactory.getLogger(Hall.class), id, address, gameTimeList);
    }

    public Hall(Logger logger, long id, Address address, List<EnableGameTime> gameTimeList) {
        this.logger = logger;
        this.id = id;
        this.address = address;
        this.gameTimeList = gameTimeList;
    }

    public Address getAddress() {
        return address;
    }

    public List<EnableGameTime> getGameTime() {
        return gameTimeList;
    }

    public void print() {
        logger.info("Printing Hall information: \n{}", this);
    }

    @Override
    public String toString() {
        return "Hall :" + "\n\tAddress: " + address + "\n\tGameTime: " + gameTimeList;
    }

    public long getID() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hall hall = (Hall) o;
        return id == hall.id &&
                Objects.equals(address, hall.address) &&
                Objects.equals(gameTimeList, hall.gameTimeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, gameTimeList);
    }
}

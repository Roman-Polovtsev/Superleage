package com.company.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Objects;

public class Hall implements Serializable {
    transient private final Logger logger;
    transient private static final long serialVersionUID = 2L;
    private final long id;
    private final Address address;
    private final EnableGameTime gameTime;

    public Hall() {
        this(LoggerFactory.getLogger(Hall.class), 1, new Address(), new EnableGameTime());
    }

    public Hall(long id, Address address) {
        this(LoggerFactory.getLogger(Hall.class), id, address, new EnableGameTime());
    }

    public Hall(EnableGameTime gameTime) {
        this(LoggerFactory.getLogger(Hall.class), 1, new Address(), gameTime);
    }

    public Hall(long id, Address address, EnableGameTime gameTime) {
        this(LoggerFactory.getLogger(Hall.class), id, address, gameTime);
    }

    public Hall(Logger logger, long id, Address address, EnableGameTime gameTime) {
        this.logger = logger;
        this.id = id;
        this.address = address;
        this.gameTime = gameTime;
    }

    public Address getAddress() {
        return address;
    }

    public EnableGameTime getGameTime() {
        return gameTime;
    }

    public void print() {
        logger.info("Printing Hall information: \n{}", this);
    }

    @Override
    public String toString() {
        return "Hall :" + "\n\tAddress: " + address + "\n\tGameTime: " + gameTime;
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
                Objects.equals(logger, hall.logger) &&
                Objects.equals(address, hall.address) &&
                Objects.equals(gameTime, hall.gameTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logger, id, address, gameTime);
    }
}

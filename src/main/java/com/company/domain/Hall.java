package com.company.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Objects;

public class Hall implements Serializable {

    transient private static final Logger logger = LoggerFactory.getLogger(Hall.class);
    private static final long serialVersionUID = 2L;

    private final Address address;

    private final EnableGameTime gameTime;

    public Hall() {
        this(new Address(), new EnableGameTime());
    }

    public Hall(Address address) {
        this(address, new EnableGameTime());
    }

    public Hall(EnableGameTime gameTime) {
        this(new Address(), gameTime);
    }

    public Hall(Address address, EnableGameTime gameTime) {
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

        logger.info("{}", "Printing Hall information: \n{}", this);
    }

    @Override
    public String toString() {
        return "Hall :" + "\n\tAddress: " + address + "\n\tGameTime: " + gameTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hall hall = (Hall) o;
        return Objects.equals(address, hall.address) &&
                Objects.equals(gameTime, hall.gameTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, gameTime);
    }
}

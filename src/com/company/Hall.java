package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hall {
    private Address address;
    private EnableGameTime gameTime;

    //making constrictor
    Hall( Address address ){
       Main.addHallAddr(this, address );

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public EnableGameTime getGameTime() {
        return gameTime;
    }

    public void setGameTime(EnableGameTime gameTime) {
        this.gameTime = gameTime;
    }
}

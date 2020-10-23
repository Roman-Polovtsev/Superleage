package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hall {
    private Address address;
    //private Set<Address> addressSet = new HashSet<Address>();
    private EnableGameTime gameTime;

    //making constrictor
    Hall( Address address ){
       main.addHallAddr(this.Hall, address );

    }

//    public Set<Address> getAddressSet() {
//        return addressSet;
//    }
//
//    public void setAddressSet(Set<Address> addressSet) {
//        Hall.addressSet = addressSet;
//    }

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

package com.company;

public class Hall {

    private Address address;
    private EnableGameTime gameTime;


    public Hall(Address address) {
        this.address = address;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        Main.addHallAddr(this, address);
    }

    public EnableGameTime getGameTime() {
        return gameTime;
    }

    public void setGameTime(EnableGameTime gameTime) {
        this.gameTime = gameTime;
    }

    public void print() {
        System.out.println("Hall " + this + "\nAddress: " + address);
    }

    @Override
    public String toString() {
        return "The best hall ever";
    }
}

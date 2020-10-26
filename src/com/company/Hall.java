package com.company;

public class Hall {

    private final Address address;
    private EnableGameTime gameTime;

    public Hall(){
        this( new Address(), new EnableGameTime() );
    }

    public Hall( Address address, EnableGameTime gameTime) {
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
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Hall :" +  "\nAddress: " + address + "\nGameTime: " + gameTime;
    }


}

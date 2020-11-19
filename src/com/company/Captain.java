package com.company;

public class Captain extends Player {
    private String number;
    private String email;

    public Captain (){
        super();
        this.number = "not stated";
        this.email = "not stated";
    }

    public Captain (Player player){
        super(player.getName(),player.getYearOfBirth(), player.getLevel(), player.getPosition(), player.getHeight());
        this.number = "not stated";
        this.email = "not stated";
    }

    public Captain (Player player, String number, String email){
        super(player.getName(),player.getYearOfBirth(), player.getLevel(), player.getPosition(), player.getHeight());
        this.number = number;
        this.email = email;
    }


    @Override
    public String toString() {
        return "Team captain: " + super.getName() + "\nContacts: " +"\nphone: "+ number + "\nemail: " + email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

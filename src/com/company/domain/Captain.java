package com.company.domain;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Captain captain = (Captain) o;
        return Objects.equals(number, captain.number) &&
                Objects.equals(email, captain.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number, email);
    }
}

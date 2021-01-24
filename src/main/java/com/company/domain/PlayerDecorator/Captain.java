package com.company.domain.PlayerDecorator;

import java.io.Serializable;
import java.util.Objects;

public class Captain implements AbstractPerson, Serializable {
    transient private static final long serialVersionUID = 15L;
    private final Player player;
    private final String phoneNumber;
    private final String email;

    public Captain(){
        this(new Player(),"","");
    }

    public Captain(Player player, String phoneNumber, String email) {
        this.player = player;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Player getPlayer(){
        return this.player;
    }

    public String getContacts() {
        return "Captain contacts: \n" + this.phoneNumber + "\t" + this.email;
    }

    @Override
    public String getName() {
        return player.getName();
    }

    @Override
    public int getYearOfBirth() {
        return player.getYearOfBirth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Captain captain = (Captain) o;
        return Objects.equals(phoneNumber, captain.phoneNumber) &&
                Objects.equals(email, captain.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, email);
    }

    @Override
    public String toString() {
        return "Captain{" +
                "player=" + player +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

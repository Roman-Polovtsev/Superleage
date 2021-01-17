package com.company.domain;

import java.util.Objects;

public class Captain extends Player {
    private final String number;
    private final String email;

    public Captain() {
        this(new Player());
    }

    public Captain(Player player) {
        this(player, "not stated", "not stated");
    }

    public Captain(Player player, String number, String email) {
        super(player.getName(), player.getYearOfBirth(), player.getId(), player.getLevel(), player.getPosition(), player.getHeight());
        this.number = number;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Team captain: " + super.getName() + "\nContacts: " + "\nphone: " + number + "\nemail: " + email;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
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

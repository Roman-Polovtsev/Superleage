package com.company.domain.GameDecorator;

import com.company.domain.Address;
import com.company.domain.Team;

import java.time.LocalDateTime;
import java.util.Objects;

public class GameDecorator implements Game{
    Game game;

    public GameDecorator(Game game) {
        this.game = game;
    }

    @Override
    public long getID() {
        return this.getID();
    }

    @Override
    public Team getHome() {
        return this.getHome();
    }

    @Override
    public Team getGuest() {
        return this.getGuest();
    }

    @Override
    public Address getGameAddress() {
        return this.getGameAddress();
    }


    @Override
    public LocalDateTime getGameTime() {
        return this.getGameTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameDecorator that = (GameDecorator) o;
        return Objects.equals(game, that.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game);
    }
}

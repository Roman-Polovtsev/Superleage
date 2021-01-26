package com.company.domain.PlayerDecorator;

import com.company.domain.IdHolders;
import java.util.Objects;

public class Player extends PersonDecorator implements IdHolders {
    transient private static final long serialVersionUID = 17L;
    public static long idCounter = 1;
    private final long id;
    private final int height;
    private final String position;
    private final String level;

    public Player() {
        this(new DefinedPerson(), 0, "", "");
    }

    public Player(AbstractPerson abstractPerson) {
        this(abstractPerson, 190, "setter", "master");
    }

    public Player(AbstractPerson abstractPerson, int height, String position, String level) {
        super(abstractPerson);
        this.id = idCounter;
        this.height = height;
        this.position = position;
        this.level = level;
        idCounter++;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getYearOfBirth() {
        return super.getYearOfBirth();
    }

    public int getHeight() {
        return height;
    }

    public String getPosition() {
        return position;
    }

    public String getLevel() {
        return level;
    }

//    public AbstractPerson getPerson (){
//        return super;
//    }

    @Override
    public long getID() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return height == player.height &&
                Objects.equals(position, player.position) &&
                Objects.equals(level, player.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, position, level);
    }

    @Override
    public String toString() {
        return "Player{" +
                "height=" + height +
                ", position='" + position + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

}
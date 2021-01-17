package com.company.domain.PlayerDecorator;

public class Player extends PersonDecorator{
    private final int height;
    private final String position;
    private final String level;

    public Player(AbstractPerson abstractPerson) {
        this(abstractPerson,190,"setter","master");
    }

    public Player(AbstractPerson abstractPerson, int height, String position, String level) {
        super(abstractPerson);
        this.height = height;
        this.position = position;
        this.level = level;
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
}

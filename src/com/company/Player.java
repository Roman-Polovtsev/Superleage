package com.company;

public class Player extends Person{
    private final String level;
    private final String position;
    private final int height;

    Player(){
        super("John Doe",1990);
        this.level = "amateur";
        this.position = "not stated";
        this.height = 0;
    }

    public Player(String name, int yearOfBirth, String level, String position, int height) {
        super(name, yearOfBirth);
        this.level = level;
        this.position = position;
        this.height = height;
    }

    public String getLevel() {
        return level;
    }

    public String getPosition() {
        return position;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getYearOfBirth() {
        return super.getYearOfBirth();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}

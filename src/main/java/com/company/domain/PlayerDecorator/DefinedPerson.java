package com.company.domain.PlayerDecorator;

public class DefinedPerson implements AbstractPerson{
    transient private static final long serialVersionUID = 17L;
    private final String name;
    private final int yearOfBirth;

    public DefinedPerson() {
        this("Ivan",1995);
    }

    public DefinedPerson(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getYearOfBirth() {
        return this.yearOfBirth;
    }
}

package com.company.domain.PlayerDecorator;

public class ConcretePerson implements AbstractPerson{
    private final String name;
    private final int yearOfBirth;

    public ConcretePerson() {
        this("Ivan",1995);
    }

    public ConcretePerson(String name, int yearOfBirth) {
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

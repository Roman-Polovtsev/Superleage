package com.company.domain.PlayerDecorator;

public class PersonDecorator implements AbstractPerson{
    AbstractPerson abstractPerson;
    private final String name;
    private final int yearOfBirth;

    public PersonDecorator(AbstractPerson abstractPerson) {
        this(abstractPerson,"Ivan",1995);
    }

    public PersonDecorator(AbstractPerson abstractPerson, String name, int yearOfBirth) {
        this.abstractPerson = abstractPerson;
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

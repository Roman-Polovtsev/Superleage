package com.company.domain.PlayerDecorator;

public class PersonDecorator implements AbstractPerson {
    private final AbstractPerson abstractPerson;

    public PersonDecorator(AbstractPerson abstractPerson) {
        this.abstractPerson = abstractPerson;
    }

    @Override
    public String getName() {
        return abstractPerson.getName();
    }

    @Override
    public int getYearOfBirth() {
        return abstractPerson.getYearOfBirth();
    }

}

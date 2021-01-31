package com.company.domain.PlayerDecorator;

public class PersonDecorator implements Person {
    private final Person person;

    public PersonDecorator(Person person) {
        this.person = person;
    }

    @Override
    public String getName() {
        return person.getName();
    }

    @Override
    public int getYearOfBirth() {
        return person.getYearOfBirth();
    }

    @Override
    public long getID(){
        return  person.getID();
    }

}

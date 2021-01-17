package com.company.domain.PlayerDecorator;

public class Captain extends Player {
    private final String phoneNumber;
    private final String email;

    public Captain(AbstractPerson abstractPerson, String phoneNumber, String email) {
        super(abstractPerson);
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getContacts() {
        return "Captain contacts: \n" + this.phoneNumber + "\t" + this.email;
    }

}

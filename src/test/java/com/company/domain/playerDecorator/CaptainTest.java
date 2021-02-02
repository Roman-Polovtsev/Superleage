package com.company.domain.playerDecorator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CaptainTest {
    Captain captain = new Captain(new Player(new DefinedPerson()),"88005553535","hello.com",1);

    @Test
    public void getContacts() {
        String contacts = captain.getContacts();

        assertTrue(contacts.contains("88005553535"));
        assertTrue(contacts.contains("hello.com"));
    }
}
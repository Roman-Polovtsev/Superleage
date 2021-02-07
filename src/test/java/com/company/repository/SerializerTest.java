package com.company.repository;

import com.company.domain.playerDecorator.DefinedPerson;
import com.company.domain.playerDecorator.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
@Ignore
public class SerializerTest {
    Serializer serializer = new Serializer();
    Player player1 = new Player(new DefinedPerson(/*"vasya"*/));
    Player player2 = new Player(new DefinedPerson(/*"vasya"*/));
    byte[] serialized1;
    byte[] serialized2;

    @Test
    @Before
    public void serializeTest() throws IOException {

        serialized1 = serializer.serialize(player1);
        serialized2 = serializer.serialize(player2);

        assertArrayEquals(serialized1, serialized2);
    }


    @Test
    @After
    public void deserializeTest() throws IOException, ClassNotFoundException {

        Object deserialized1 = serializer.deserialize(serialized1);
        Object deserialized2 = serializer.deserialize(serialized2);

        assertEquals(deserialized1, deserialized2);
        assertTrue(deserialized1 instanceof Player);
        assertTrue(deserialized2 instanceof Player);
    }
}
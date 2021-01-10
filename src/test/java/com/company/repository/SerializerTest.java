package com.company.repository;

import com.company.domain.Player;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SerializerTest {

    @Test
    public void serializeTest() throws IOException {
        Serializer serializer = new Serializer();
        Player player1 =  new Player("vasya");
        Player player2 =  new Player("vasya");

        byte[] serialize1 = serializer.serialize(player1);
        byte[] serialize2 = serializer.serialize(player2);

        assertArrayEquals(serialize1,serialize2);
    }


    @Test
    public void deserializeTest() throws IOException, ClassNotFoundException {
        Serializer serializer = new Serializer();
        byte[] first = {(byte)1,(byte) 2};
        byte[] second = {(byte)1,(byte) 2};

        Object deserialize = serializer.deserialize(first);
        Object deserialize1 = serializer.deserialize(second);

        assertEquals(deserialize,deserialize1);
    }
}
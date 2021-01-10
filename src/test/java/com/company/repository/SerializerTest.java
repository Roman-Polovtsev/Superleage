package com.company.repository;

import com.company.domain.Player;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class SerializerTest {

    private Object actual;

    @Test
    public void serializeTest() throws IOException {
//        Serializer serializer = new Serializer();
//        Player [] players = {new Player()};
//        List<Player> playerList = Arrays.asList(players);
////        ByteArrayOutputStream byteArrayOutputStream = Mockito.mock(ByteArrayOutputStream.class);
////        ObjectOutputStream objectOutputStream = Mockito.mock(ObjectOutputStream.class);
//
//        byte[] actual = serializer.serialize(playerList);
//
//
//        assertArrayEquals(playerList,actual);
    }


    @Test
    public void deserializeTest() {

    }
}
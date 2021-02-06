package com.company;

import org.junit.Test;

import java.util.UUID;

public class UUIDTest {

    @Test
    public void name() {
        String uuid = UUID.randomUUID().toString();

        System.out.println(uuid);
    }
}

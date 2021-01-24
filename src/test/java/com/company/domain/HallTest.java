package com.company.domain;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class HallTest {
    Address address = new Address(1,"a","b","c");
    Hall hall = new Hall(1,address);

    @Test
    public void print() {
        hall.print();

    }
}
package com.company.domain;

import org.junit.rules.Stopwatch;

import java.util.logging.Logger;

public class ResultTest {

    //add logger library as jar;
    //replace system.out to logger.info / warning / ...


    private final static Logger logger = Logger.getLogger("Our logger");


    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        logger.info(stopwatch.toString());
        Result start = new Result();
        start = start.incrementGuestPoint();
        System.out.println(start);
    }


}

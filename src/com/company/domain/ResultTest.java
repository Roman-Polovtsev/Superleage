package com.company.domain;



import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.log4j.PropertyConfigurator;

public class ResultTest {

    //add logger library as jar;
    //replace system.out to logger.info / warning / ...


   // private final static Logger logger = Logger.getLogger("Our logger");


    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(ResultTest.class);

       // BasicConfigurator.configure();
        PropertyConfigurator.configure("log4j2.properties");
        logger.info("кулебяка");
        Result start = new Result();
        start = start.incrementGuestPoint();
        System.out.println(start);
    }


}

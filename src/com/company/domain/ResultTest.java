package com.company.domain;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.log4j.PropertyConfigurator;


import java.io.FileInputStream;
import java.util.Properties;


public class ResultTest {

    //add logger library as jar;
    //replace system.out to logger.info / warning / ...
    private final static Logger logger = LoggerFactory.getLogger(ResultTest.class);

   // private final static Logger logger = Logger.getLogger("Our logger");


    public static void main(String[] args) {
        Properties props = new Properties();

//        try{props.load(new FileInputStream("C:\\Users\\Public\\Documents\\log4j.properties"));}
//        catch (Exception exception){
//            logger.info("{}","exception");
//        }
//        PropertyConfigurator.configure(props);

        String log4jConfPath = "C:\\Users\\Роман\\IdeaProjects\\Superleage\\src\\resources\\log4j.xml";
        DOMConfigurator.configure(log4jConfPath);

       // PropertyConfigurator.configure("C:\\Users\\Роман\\IdeaProjects\\Superleage\\src\\com\\company\\domain\\resources\\log4j.properties");
        logger.info("{}","кулебяка");
        logger.debug("debug");
        logger.error("error");
        logger.trace("trace");
        Result start = new Result();
        start = start.incrementGuestPoint();
        logger.info("{}","Home score: {} \n\t\t Guest score: {} \n{}",start.getHomeScore(),start.getGuestScore(), start);
    }


}

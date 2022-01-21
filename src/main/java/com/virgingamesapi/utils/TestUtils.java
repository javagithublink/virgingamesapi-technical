package com.virgingamesapi.utils;

import org.apache.log4j.PropertyConfigurator;

import java.util.Random;

public class TestUtils {


    public TestUtils() {


       PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/java/resources/propertyfile/log4j2.properties");
    }

    public static String getRandomValue(){
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        return Integer.toString(randomInt);
    }
}

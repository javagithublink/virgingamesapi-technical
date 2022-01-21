package com.virgingamesapi.utils;

import org.apache.log4j.PropertyConfigurator;

public class TestUtils {


    public TestUtils() {

        /**
         * Configured log4j to create logs of all steps
         */

        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/java/resources/propertyfile/log4j2.properties");
    }


}

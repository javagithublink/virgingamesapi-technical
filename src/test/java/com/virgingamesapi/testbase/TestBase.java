package com.virgingamesapi.testbase;

import com.virgingamesapi.utils.PropertyReader;
import com.virgingamesapi.utils.TestUtils;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase extends TestUtils {

    /**
     * TestBase class to initiate base url through RestAssured
     */


    //variable declaration
    public static PropertyReader propertyReader;


    // 'init' method is with @BeforeClass annotation to ensure url gets instantiated before class methods
    @BeforeClass
    public static void init() {

        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");

    }
}

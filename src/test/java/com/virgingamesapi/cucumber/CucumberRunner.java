package com.virgingamesapi.cucumber;


import com.virgingamesapi.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

//@RunWith annotation tells JUnit that tests should run using Cucumber with serenity class
//@CucumberOptions can be used to provide additional configuration to the runner.
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/feature/")


public class CucumberRunner extends TestBase {


}

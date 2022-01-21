package com.virgingamesapi.cucumber.steps;

import com.virgingamesapi.gamesinfo.GamesSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class GameTimeStampSteps {

    //variable declaration to store values of response, so that we can use it for multiple steps if needed
    public static long currentTimeStamp;
    public static List<Long> startTimeList;

    @Steps
    GamesSteps gamesSteps;

    @And("^User gets current timestamp$")
    public void userGetsCurrentTimestamp() {
        currentTimeStamp = gamesSteps.currentTimeStamp();
    }

    @And("^User compares games timestamp with current timestamp$")
    public void userComparesGamesTimestampWithCurrentTimestamp() {
        startTimeList = gamesSteps.extractTimeStamps();
    }

    @Then("^User is able to verify that timestamp value is in future$")
    public void userIsAbleToVerifyThatTimestampValueIsInFuture() {
         gamesSteps.verifyGameTimeStamps();
    }


}

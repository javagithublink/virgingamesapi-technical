package com.virgingamesapi.cucumber.steps;

import com.virgingamesapi.gamesinfo.GamesSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class GameFrequencySteps {

    //variable declaration to store values of response, so that we can use it for multiple steps if needed
    static List<Integer> defaultGameFrequency;

    @Steps
    GamesSteps gamesSteps;


    @And("^User extracts default value of all game frequency$")
    public void userExtractsDefaultValueOfAllGameFrequency() {

        defaultGameFrequency = gamesSteps.extractDefaultGameFrequency();

    }


    @Then("^User is able to verify default value of game frequency$")
    public void userIsAbleToVerifyDefaultValueOfGameFrequency() {
            gamesSteps.verifyDefaultGameFrequency();
    }


}

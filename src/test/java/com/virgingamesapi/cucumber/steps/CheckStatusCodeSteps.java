package com.virgingamesapi.cucumber.steps;

import com.virgingamesapi.gamesinfo.GamesSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class CheckStatusCodeSteps {

    //variable declaration to store values of response, so that we can use it for multiple steps if needed
    static ValidatableResponse response;


    @Steps
    GamesSteps gamesSteps;

    @When("^User sends a GET request with '/bingo' path and '/GetBingoLobbyFeed\\.do' end point$")
    public void userSendsAGETRequestWithBingoPathAndGetBingoLobbyFeedDoEndPoint() {

        gamesSteps.sendGETRequest();
    }

    @Then("^User gets valid status code '200'$")
    public void userGetsValidStatusCode() {
        response = gamesSteps.checkStatusCode();
    }
}

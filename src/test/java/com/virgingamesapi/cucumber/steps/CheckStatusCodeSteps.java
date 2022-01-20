package com.virgingamesapi.cucumber.steps;

import com.virgingamesapi.gamesinfo.GamesSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class CheckStatusCodeSteps {

    static ValidatableResponse response;

    @Steps
    GamesSteps gamesSteps;

    @When("^User sends a GET request with '/bingo' path and '/GetBingoLobbyFeed\\.do' end point$")
    public void userSendsAGETRequestWithBingoPathAndGetBingoLobbyFeedDoEndPoint() {

        response = gamesSteps.checkStatusCode();
    }

    @Then("^User gets valid status code '200'$")
    public void userGetsValidStatusCode() {
        response = gamesSteps.checkStatusCode();
    }
}

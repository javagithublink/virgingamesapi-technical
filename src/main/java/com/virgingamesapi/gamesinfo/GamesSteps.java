package com.virgingamesapi.gamesinfo;

import com.virgingamesapi.constants.EndPoints;
import com.virgingamesapi.constants.Path;
import com.virgingamesapi.utils.TestUtils;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class GamesSteps extends TestUtils {

    /**
     * GamesSteps class to write methods, which have been used within cucumber steps
     */


    // variable declaration
    public static ValidatableResponse response;
    public static List<Integer> DefaultGameFrequencyList;
    public static long currentTimeStamp;
    public static List<Long> startTimeList;
    public static Response response1;
    private static final Logger log = LogManager.getLogger(GamesSteps.class.getName());


    //@Step shows step info onto serenity report
    @Step ("Sending GET request")
    public void sendGETRequest(){
        log.info("Sending GET request");
        response1 = SerenityRest.given().log().all()
                .when()
                .get(Path.BINGO + EndPoints.LOBBY_FEED);
    }



    @Step("Checking status code of successful GET request")
    public ValidatableResponse checkStatusCode() {

        log.info("Checking status code of successful GET request");
        response = SerenityRest.given().log().all()
                .when()
                .get(Path.BINGO + EndPoints.LOBBY_FEED)
                .then().statusCode(200);

        return response;

    }


    @Step("Extracting default game frequency of all games")
    public List<Integer> extractDefaultGameFrequency() {

        log.info("Extracting default game frequency of all games");
        DefaultGameFrequencyList = response.extract().jsonPath().get("bingoLobbyInfoResource.streams.defaultGameFrequency");

        return DefaultGameFrequencyList;

    }

    @Step("Verifying default game frequency")
    public void verifyDefaultGameFrequency() {
        log.info("Verifying default game frequency");
        for (Integer DefaultGameFrequency : DefaultGameFrequencyList) {

            if (DefaultGameFrequency != null) {
                Assert.assertThat(DefaultGameFrequency, greaterThanOrEqualTo(300000));
                log.info("DefaultGameFrequency is " + DefaultGameFrequency);
            } else {
                log.info("DefaultGameFrequency is null");

            }
        }
    }


    @Step("Getting current timestamp")
    public long currentTimeStamp() {
        log.info("Getting current timestamp");
        return currentTimeStamp = response.extract().jsonPath().get("timestamp");

    }

    @Step("Extracting timestamps of all games ")
    public List<Long> extractTimeStamps() {
        log.info("Extracting timestamps of all games ");
        return startTimeList = response.extract().jsonPath().get("bingoLobbyInfoResource.streams.startTime");
    }

    @Step("Verifying games timestamps are in future")
    public void verifyGameTimeStamps() {
        log.info("Verifying games timestamps are in future");
        for (long startTime : startTimeList) {
            log.info("The current time is: " + currentTimeStamp);
            log.info("The start time is: " + startTime);
            log.info("Verifying games timestamps are in future");
            Assert.assertThat(startTime, greaterThan(currentTimeStamp));
        }
    }
}

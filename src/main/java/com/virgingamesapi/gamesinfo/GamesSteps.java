package com.virgingamesapi.gamesinfo;

import com.virgingamesapi.constants.EndPoints;
import com.virgingamesapi.constants.Path;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class GamesSteps {

    public static ValidatableResponse response;
    public static List<String> DefaultGameFrequencyList;
    public static long currentTimeStamp;
    public static List<Long> startTimeList;

    @Step("Checking status code of successful GET request")
    public ValidatableResponse checkStatusCode() {

        response = SerenityRest.given().log().all()
                .when()
                .get(Path.BINGO + EndPoints.LOBBY_FEED)
                .then().statusCode(200);

        return response;

    }


    @Step("Extracting default game frequency of all games")
    public List<String> extractDefaultGameFrequency() {


        DefaultGameFrequencyList = response.extract().jsonPath().get("bingoLobbyInfoResource.streams.defaultGameFrequency");

        return DefaultGameFrequencyList;

    }

    @Step("Verifying default game frequency")
    public void verifyDefaultGameFrequency() {
        System.out.println(DefaultGameFrequencyList);

        for (Object DefaultGameFrequency : DefaultGameFrequencyList) {

            if (DefaultGameFrequency != null) {
                Assert.assertThat(DefaultGameFrequency, equalTo(300000));


                System.out.println("DefaultGameFrequency is " + DefaultGameFrequency);
            } else {
                System.out.println("DefaultGameFrequency is null");
            }
        }
    }


    @Step("Getting current timestamp")
    public long currentTimeStamp() {

        return currentTimeStamp = response.extract().jsonPath().get("timestamp");
        /*System.out.println(currentTimeStamp);
        System.out.println(new Date(currentTimeStamp));
        Date date = new Date(currentTimeStamp);*/

    }

    @Step("Extracting timestamps of all games ")
    public List<Long> extractTimeStamps() {
        return startTimeList = response.extract().jsonPath().get("bingoLobbyInfoResource.streams.startTime");
    }

    @Step("Verifying games timestamps are in future")
    public void verifyGameTimeStamps() {
        Date date = new Date(currentTimeStamp);
        System.out.println(startTimeList);
        for (long startTime : startTimeList) {
            System.out.println("The current time is: " + date);
            System.out.println("The start time is: " + new Date(startTime));

            System.out.println("");
            Assert.assertThat(startTime, greaterThan(currentTimeStamp));

        }
    }
}

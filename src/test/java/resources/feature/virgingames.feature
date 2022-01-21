
#Create a project using Java that contains test(s) for the following endpoint: 'https://www.virgingames.com/bingo/GetBingoLobbyFeed.do'
#e.g. 'defaultGameFrequency' should always be '300000' or 'startTime' should always be future timestamp or any other values you can assert.

Feature: Validating different values for virgingames application

@SMOKE
  Scenario: Check that user can get access data with valid path and end points
    When    User sends a GET request with '/bingo' path and '/GetBingoLobbyFeed.do' end point
    Then    User gets valid status code '200'

  Scenario: Verify that default value of game frequency is 3000000
    When    User sends a GET request with '/bingo' path and '/GetBingoLobbyFeed.do' end point
    And     User extracts default value of all game frequency
    Then    User is able to verify default value of game frequency

  Scenario: Verify that timestamp value is always in future
    When    User sends a GET request with '/bingo' path and '/GetBingoLobbyFeed.do' end point
    And     User gets current timestamp
    And     User compares games timestamp with current timestamp
    Then    User is able to verify that timestamp value is in future

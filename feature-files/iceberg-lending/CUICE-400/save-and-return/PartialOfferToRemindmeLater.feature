@PartialOfferToRemindmeLater @SaveAndReturnPostTnC @Regression
Feature: Verify that save and return functionality is working for Final Offer to Appeal your Decision flow

  Background: This is to add category to below scenarios
    Given that category "PartialOfferToRemindmeLater" is added for below scenarios

  @Sprint10
  Scenario: CUICE-9341 >> Prerequisite: Test if user able to view  the Final Offer screen
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "5800" for lending question
    And user selects option 1 from Purpose of Borrowing question screen
    And user clicks on continue button on the screen
    And user selects option 3 on Residential Status screen
    And user clicks on continue button on the screen
    And user selects option 3 on Marital Status screen
    And user clicks on continue button on the screen
    And user enters minimum value "3500" in Gross Income input box
    And user clicks on continue button on the screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Yes button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Accept button on Terms and Conditions screen
    Then verify that the Partial Offer screen is displayed

  @Sprint10
  Scenario: CUICE-9341 >> ATC014: Logout and Login to see if user is lending to Partial Offer screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that the Partial Offer screen is displayed
    When user clicks on see my options button on the screen
    Then verify that Partial Offer Options screen is displayed

  @Sprint10
  Scenario: CUICE-9341 >> ATC015: Logout and Login to see if user is lending to Partial Offer Options screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Partial Offer Options screen is displayed
    When user clicks on Accept Overdraft CTA on the screen
    Then verify that Final Offer screen is displayed

  @Sprint10
  Scenario: CUICE-9341 >> ATC016: Logout and Login to see if user is lending to Final Offer screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Final Offer screen is displayed
    Then user clicks on Not Now button on Final Offer
    Then verify that Remind me Later screen is visible

  @Sprint10
  Scenario: CUICE-9341 >> ATC017: Logout and Login to see if user is lending to Remind me later
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Remind me Later screen is visible
    Then user clicks on No, decline the offer button on screen
    Then verify that Decline Offer screen is visible
    

@RemindmeLater @Regression
Feature: Verify all functionalities related to Remind me Later screen, it covers CUICE-10190

  Background: This is to add category to below scenarios
    Given that category "RemindmeLater" is added for below scenarios

  @Sprint6
  Scenario: CUICE-10190 >> Prerequisite: Test if user able to view  the Remind me Later screen
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "3800" for lending question
    And user selects option 1 from Purpose of Borrowing question screen
    And user clicks on continue button on the screen
    And user selects option 3 on Residential Status screen
    And user clicks on continue button on the screen
    And user selects option 3 on Marital Status screen
    And user clicks on continue button on the screen
    And user enters minimum value "1000" in Gross Income input box
    And user clicks on continue button on the screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Yes button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Accept button on Terms and Conditions screen
    And user clicks on Not Now button on Final Offer
    Then verify that Remind me Later screen is visible
    
  @Sprint6
  Scenario: CUICE-10190 >> Test if content on Remind me later screen are correct
    Given that user is on the Remind me Later screen
    Then verify that remind me later title "Remind me later" is displayed
    Then verify that remind me later heading "Need some time to decide?" is displayed
    Then verify that remind me later sub heading "The overdraft we have offered you is there for 30 days to give you extra time to decide." is displayed
    Then verify that Yes remind me later button is displayed
    Then verify that No decline the offer button is displayed
    
  @Sprint6
  Scenario: CUICE-10190 >> Test if Decline Offer screen is displayed when user clicks on No, decline the offer
    Given that user is on the Remind me Later screen
    Then user clicks on No, decline the offer button on screen
    Then verify that Decline Offer screen is visible
    Then click on No button on Decline Offer screen

  @Sprint6
  Scenario: CUICE-10190 >> Test if Remind me later screen is displayed when user clicks on Yes, remind me later
    Given that user is on the Remind me Later screen
    Then user clicks on Yes remind me later button on screen
    

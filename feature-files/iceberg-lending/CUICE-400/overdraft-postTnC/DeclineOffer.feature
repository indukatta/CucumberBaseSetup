@DeclineOffer @Regression
Feature: Verify all functionalities related to Decline Offer screen, it covers CUICE-563

  Background: This is to add category to below scenarios
    Given that category "DeclineOffer" is added for below scenarios

  @Sprint6
  Scenario: CUICE-563 >> Prerequisite: Test if user able to view  the Decline Offer screen
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
    And user clicks on No, decline the offer button on screen
    Then verify that Decline Offer screen is visible
    
  @Sprint6
  Scenario: CUICE-563 >> Test if content on Decline Offer screen are correct
    Given that user is on the Decline Offer screen
    Then verify that Decline Offer alert image is displayed
    Then verify that Decline Offer title text "Decline offer" is displayed
    Then verify that Decline Offer body text "This will end your application for borrowing. Are you sure you want to decline the offer?" is displayed
    Then verify that No button is displayed on Decline Offer screen
    Then verify that Yes button is displayed on Decline Offer screen
    
  @Sprint6
  Scenario: CUICE-563 >> Test if Remind me later screen is displayed when user clicks on No button
    Given that user is on the Decline Offer screen
    Then user clicks on No button on Decline Offer screen
    Then verify that Remind me Later screen is visible
    Then user clicks on No, decline the offer button on screen

  @Sprint6
  Scenario: CUICE-563 >> Test if User Decline screen is displayed when user clicks on Yes button
    Given that user is on the Decline Offer screen
    Then user clicks on Yes button on Decline Offer screen
    Then verify that Customer Decline screen is displayed
    

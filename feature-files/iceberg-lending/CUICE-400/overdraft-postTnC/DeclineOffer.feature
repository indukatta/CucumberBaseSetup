@DeclineOffer @Regression
Feature: Verify all functionalities related to Decline Offer screen, it covers CUICE-9953

  Background: This is to add category to below scenarios
    Given that category "DeclineOffer" is added for below scenarios

  @Sprint6
  Scenario: CUICE-9953 >> Prerequisite: Test if user able to view  the Decline Offer screen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    When user selects option 1 from Purpose of Borrowing question screen
    And user clicks on continue button on the screen
    When user selects option 3 on Residential Status screen
    And user clicks on continue button on the screen
    When user selects option 3 on Marital Status screen
    And user clicks on continue button on the screen
    When user enters minimum value "1000" in Gross Income input box
    And user clicks on continue button on the screen
    When user clicks on No button on lending question screen
    When user clicks on No button on lending question screen
    When user clicks on Yes button on lending question screen
    When user clicks on No button on lending question screen
    When user clicks on Yes button on lending question screen
    Then verify that Terms and Conditions screen is displayed
    Then user clicks on Accept button on Terms and Conditions screen
    Then wait for Processing your Application screen to disappear
    Then verify that the Final Offer screen is displayed
    Then user clicks on Not Now button on Final Offer
    Then user clicks on No decline the offer button on screen
    Then verify that Decline Offer screen is visible
    
    
  @Sprint6
  Scenario: CUICE-553 >> Test if content on Decline Offer screen are correct
    Given that user is on the Decline Offer screen
    Then verify that Decline Offer summay "Decline Offer" is displayed
    Then verify that Decline Offer description "This will end your application for borrowing. Are you sure you want to decline the offer?" is displayed
    Then verify that No button is displayed on Decline Offer screen
    Then verify that Yes button is displayed on Decline Offer screen
    
  @Sprint6
  Scenario: CUICE-553 >> Test if Remind me later screen is displayed when user clicks on No button
    Given that user is on the Decline Offer screen
    Then click on No button on Decline Offer screen
    Then verify that Remind me later screen is displayed

  @Sprint6
  Scenario: CUICE-553 >> Test if User Decline screen is displayed when user clicks on Yes button
    Given that user is on the Decline Offer screen
    Then click on Yes button on Decline Offer screen
    Then verify that User Decline screen is displayed
    

@RemindmeLater @Regression
Feature: Verify all functionalities related to Remind me Later screen, it covers CUICE-9953

  Background: This is to add category to below scenarios
    Given that category "RemindmeLater" is added for below scenarios

  @Sprint6
  Scenario: CUICE-9953 >> Prerequisite: Test if user able to view  the Remind me Later screen
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
    Then user clicks on Accept button on Terms and Conditions screen
    Then wait for Processing your Application screen to disappear
    Then user clicks on Not Now button on Final Offer
    Then verify that Remind me Later screen is visible
    
  @Sprint6
  Scenario: CUICE-553 >> Test if content on Remind me later screen are correct
    Given that user is on the Remind me Later screen
    Then verify that remind me later summay "Remind me later" is displayed
    Then verify that remind me later description "The overdraft we have offered you is there for 30 days to give you extra time to decide." is displayed
    Then verify that Yes remind me later button is displayed
    Then verify that NO decline the offer button is displayed
    
  @Sprint6
  Scenario: CUICE-553 >> Test if Decline Offer screen is displayed when user clicks on No, decline the offer
    Given that user is on the Remind me Later screen
    Then user clicks on No decline the offer button on screen
    Then verify that Decline Offer screen is displayed

  @Sprint6
  Scenario: CUICE-553 >> Test if Remind me later screen is displayed when user clicks on Yes, remind me later
    Given that user is on the Remind me Later screen
    Then user clicks on Yes remind me later button on screen
    

@TnCHardCheck @Regression
Feature: Verify all functionalities related to Amount of Borrowing No screen, it covers CUICE-552, CUICE-553

  Background: This is to add category to below scenarios
    Given that category "TnCHardCheck" is added for below scenarios

  Scenario: CUICE-552 >> Prerequisite: Test if user able to view  the Terms and Conditions screen
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
    Then verify that SustainabilityCheck screen is displayed
    When user clicks on Yes button on lending question screen
    Then verify that Terms and Conditions screen is displayed

  Scenario: CUICE-553 >> Test if Processing your Applications screen is visible
    Given that user is on the Terms and Conditions screen
    When user clicks on Accept button on Terms and Conditions screen
    Then verify that Processing your Application screen is displayed

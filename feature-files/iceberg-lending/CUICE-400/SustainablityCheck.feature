@SustainabilityCheck @Regression
Feature: Verify all functionalities related to Amount of Borrowing No screen, it covers CUICE-6171

  Background: This is to add category to below scenarios
    Given that category "SustainabilityCheck" is added for below scenarios

  @Sprint4 @Sprint5
  Scenario: CUICE-6171 >> Prerequisite: Test if user able to view  the Borrowings Yes No screen
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
    When user enters minimum value "1" in Gross Income input box
    And user clicks on continue button on the screen
    When user clicks on No button on lending question screen
    When user clicks on No button on lending question screen
    When user clicks on Yes button on lending question screen
    When user clicks on No button on lending question screen
    Then verify that SustainabilityCheck screen is displayed

  @Sprint4
  Scenario: CUICE-6171 >> ATC-001: Test if user is able to see default message on the screen and Okay button
    Given that user is on SustainabilityCheck screen
    Then verify that SustainabilityCheck question "Do you know of any changes in your circumstances that could affect the business’ ability to repay this borrowing?" is displayed
    And verify that Yes button is displayed on lending question screen
    And verify that No button is displayed on lending question screen
    And verify that Yes button is not selected on lending question screen
    And verify that No button is not selected on lending question screen

  @Sprint4 @Sprint5
  Scenario: CUICE-6174 >> ATC-002: Test if user clicks on No, Questions screen is displayed
    Given that user is on SustainabilityCheck screen
    When user clicks on No button on lending question screen
    Then verify that Terms and Conditions screen is displayed
    And user clicks on back button on lending question screen

  @Sprint5
  Scenario: CUICE-TBD >> ATC-TBD: Test if save and return is working when user clicks on No button
    Then verify that No button is selected on lending question screen
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/SustainabilityCheckNo" is equals to "data/application/answers" except "dateModified" key
    When user clicks on No button on lending question screen
    Then verify that Terms and Conditions screen is displayed
    And user clicks on back button on lending question screen
    Then verify that No button is selected on lending question screen
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/SustainabilityCheckNo" is equals to "data/application/answers" except "dateModified" key

  @Sprint4 @Sprint5
  Scenario: CUICE-6174 >> ATC-002: Test if user clicks on No, Questions screen is displayed
    Given that user is on SustainabilityCheck screen
    When user clicks on Yes button on lending question screen
    Then verify that Terms and Conditions screen is displayed
    And user clicks on back button on lending question screen

  @Sprint5
  Scenario: CUICE-TBD >> ATC-TBD: Test if save and return is working when user clicks on No button
    Then verify that Yes button is selected on lending question screen
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/SustainabilityCheckYes" is equals to "data/application/answers" except "dateModified" key
    When user clicks on Yes button on lending question screen
    Then verify that Terms and Conditions screen is displayed
    And user clicks on back button on lending question screen
    Then verify that Yes button is selected on lending question screen
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/SustainabilityCheckYes" is equals to "data/application/answers" except "dateModified" key

@YearsOfPersonalAccount @Regression
Feature: Verify all functionalities related to Year of Current Account screen, it covers CUICE-6267

  Background: This is to add category to below scenarios
    Given that category "YearsOfPersonalAccount" is added for below scenarios

  @Sprint4 @Sprint5
  Scenario: CUICE-6267 >> Prerequisite: Test if user able to view  the Year of Current Account screen
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    When user selects option 1 from Purpose of Borrowing question screen
    And user clicks on continue button on the screen
    When user selects option 3 on Residential Status screen
    And user clicks on continue button on the screen
    When user selects option 2 on Marital Status screen
    And user clicks on continue button on the screen
    When user enters minimum value "11231" in Gross Income input box
    And user clicks on continue button on the screen
    When user clicks on Yes button on lending question screen
    Then verify that Years of Personal Account screen is displayed

  @Sprint4
  Scenario: CUICE-6267 >> ATC-001: Test if user is able to see default content and state on the screen
    Given that user is on Years of Personal Account screen
    Then verify that Years of Personal Account question "How many full years have you had your personal current account?" is displayed
    And verify that maximum limit number of years "10+" is displayed on the screen
    Then verify that number of years field is equels to "0" on the screen
    And verify that continue button is enabled

  @Sprint4
  Scenario: CUICE-6267 >> ATC-002: Test if user is able to select the number of years through slider
    Given that user is on Years of Personal Account screen
    When user selects option 4 on Years of Persoanl Account screen
    Then verify that number of years field is equels to "4" on the screen
    When user selects option 10 on Years of Persoanl Account screen
    Then verify that number of years field is equels to "10+" on the screen

  @Sprint4 @Sprint5
  Scenario: CUICE-6267 >> ATC-003: Test if selected number of years value is stored on the screen
    Given that user is on Years of Personal Account screen
    When user selects option 10 on Years of Persoanl Account screen
    Then user clicks on continue button on the screen
    Then user clicks on back button on lending question screen
    Then verify that number of years field is equels to "10+" on the screen
    When user call rest end point "question-configuration" to get and save the response
    Then verify that expected json "lending-QnA/YearsOfPersonalAccount10" is equals to "data/application/answers" except "dateModified" key

  @Sprint4
  Scenario: CUICE-6267 >> ATC-003: Test if selected number of years value is stored on the screen
    Given that user is on Years of Personal Account screen
    Then user clicks on back button on lending question screen
    Then user clicks on continue button on the screen
    Then verify that number of years field is equels to "10+" on the screen

  @Sprint5
  Scenario: CUICE-6267 >> ATC-004: Test if save and return is working when user select years of Personal Account
    Given that category "SaveAndReturnPreTnC" is added for below scenarios
    When user selects option 4 on Years of Persoanl Account screen
    Then user clicks on continue button on the screen
    When user call rest end point "question-configuration" to get and save the response
    Then verify that expected json "lending-QnA/YearsOfPersonalAccount4" is equals to "data/application/answers" except "dateModified" key
    Then user clicks on back button on lending question screen
    Then verify that number of years field is equels to "4" on the screen

@AmountOfBorrowingYesNo @Regression
Feature: Verify all functionalities related to Amount of Borrowings Yes No screen, it covers CUICE-6171, CUICE-544

  Background: This is to add category to below scenarios
    Given that category "AmountOfBorrowingYesNo" is added for below scenarios

  @Sprint4 @Sprint5
  Scenario: CUICE-6171 >> Prerequisite: Test if user able to view  the Amount of Borrowings Yes No screen
    Given that user is on the Credit Management screen
    Then close existing open application for the next scenario
    When user clicks on the Credit & Lending link
    When user clicks on Apply button on Product Selection
    Then verify that Amount of Borrowing YesNo screen is displayed

  @Sprint4
  Scenario: CUICE-6171 >> ATC-001: Test if user is able to see header, Yes No buttons and its default state
    Given that user is on Amount of Borrowing YesNo screen
    Then verify that Amount of Borrowing title "Borrowing" on screen
    Then verify that Amount of Borrowing question "Do you know how much you would like to borrow?" on screen
    And verify that Yes button is displayed on lending question screen
    And verify that No button is displayed on lending question screen
    And verify that Yes button is not selected on lending question screen
    And verify that No button is not selected on lending question screen

  @Sprint4 @Sprint5
  Scenario: CUICE-6171 >> ATC-002: Test if save and return is working when user clicks on No button
    Given that user is on Amount of Borrowing YesNo screen
    When user clicks on No button on lending question screen
    Then verify that Amount of Borrowing No screen is displayed
    Then user clicks on back button on lending question screen

  @Sprint5
  Scenario: CUICE-6171,CUICE-544 >> ATC-003: Test if save and return is working when user clicks on No button
  	Given that category "SaveAndReturnPreTnC" is added for below scenarios
    Then verify that No button is selected on lending question screen
    When user call rest end point "question-configuration" to get and save the response
    Then verify that expected json "lending-QnA/AmountOfBorrowingNo" is equals to "data/application/answers" except "dateModified" key

  @Sprint4 @Sprint5
  Scenario: CUICE-6171 >> ATC-004: Test if save and return is working when user clicks on Yes button
    Given that user is on Amount of Borrowing YesNo screen
    When user clicks on Yes button on lending question screen
    Then verify that Amount of Borrowing screen is displayed
    Then user clicks on back button on lending question screen

  @Sprint5
  Scenario: CUICE-6171,CUICE-544 >> ATC-005: Test if save and return is working when user clicks on Yes button
  	Given that category "SaveAndReturnPreTnC" is added for below scenarios
    Then verify that Yes button is selected on lending question screen
    When user call rest end point "question-configuration" to get and save the response
    Then verify that expected json "lending-QnA/AmountOfBorrowingYes" is equals to "data/application/answers" except "dateModified" key

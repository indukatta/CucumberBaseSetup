@DeclinedPaymentYesNo @Regression
Feature: Verify all functionalities related to Borrowing Yes No screen, it covers CUICE-6272,CUICE-544

  Background: This is to add category to below scenarios
    Given that category "DeclinedPaymentYesNo" is added for below scenarios

  @Sprint4 @Sprint5
  Scenario: CUICE-6272 >> Prerequisite: Test if user able to view  the Borrowings Yes No screen
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
    Then verify that Declined Payment YesNo screen is displayed

  @Sprint4
  Scenario: CUICE-6272 >> ATC-001: Test if user is able to see Yes No buttons and its default state
    Given that user is on Declined Payment YesNo screen
    Then verify that Declined Payment YesNo question "Has your business had a declined payment* in the last 3 months?" is displayed
    And verify that Yes button is displayed on lending question screen
    And verify that No button is displayed on lending question screen
    And verify that Yes button is not selected on lending question screen
    And verify that No button is not selected on lending question screen
    And verify that hint text "*This includes direct debit, standing order or a cheque." is displayed

  @Sprint4 @Sprint5
  Scenario: CUICE-6272 >> ATC-002: Test if user clicks on No, next questions screen is displayed
    Given that user is on Declined Payment YesNo screen
    When user clicks on No button on lending question screen
    Then verify that Business Borrowing YesNo screen is displayed
    And user clicks on back button on lending question screen

  @Sprint5
  Scenario: CUICE-6272,CUICE-544 >> ATC-003: Test if save and return is working when user clicks on No button
  	Given that category "SaveAndReturnPreTnC" is added for below scenarios
    Then verify that No button is selected on lending question screen
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/DeclinedPaymentNo" is equals to "data/application/answers" except "dateModified" key
    When user clicks on No button on lending question screen
    Then verify that Business Borrowing YesNo screen is displayed
    And user clicks on back button on lending question screen
    Then verify that No button is selected on lending question screen
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/DeclinedPaymentNo" is equals to "data/application/answers" except "dateModified" key

  @Sprint4 @Sprint5
  Scenario: CUICE-6272 >> ATC-004: Test if user clicks on Yes, next questions screen is displayed
    Given that user is on Declined Payment YesNo screen
    When user clicks on Yes button on lending question screen
    Then verify that Business Borrowing YesNo screen is displayed
    And user clicks on back button on lending question screen

  @Sprint5
  Scenario: CUICE-6272,CUICE-544 >> ATC-005: Test if save and return is working when user clicks on Yes button
  	Given that category "SaveAndReturnPreTnC" is added for below scenarios
    Then verify that Yes button is selected on lending question screen
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/DeclinedPaymentYes" is equals to "data/application/answers" except "dateModified" key
    When user clicks on Yes button on lending question screen
    Then verify that Business Borrowing YesNo screen is displayed
    And user clicks on back button on lending question screen
    Then verify that Yes button is selected on lending question screen
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/DeclinedPaymentYes" is equals to "data/application/answers" except "dateModified" key

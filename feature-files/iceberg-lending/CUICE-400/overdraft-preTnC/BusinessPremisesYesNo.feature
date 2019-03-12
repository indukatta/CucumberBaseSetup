@BusinessPremisesYesNo @Regression
Feature: Verify all functionalities related to Business Premises Yes/No screen, it will cover following stories CUICE-6174

  Background: This is to add category to below scenarios
    Given that category "BusinessPremisesYesNo" is added for below scenarios

  @Sprint3 @Sprint5
  Scenario: CUICE-6174 >> Prerequisite: Test if user able to view  the Business Premises YesNo screen
    Given that user is on the Credit Management screen
    Then close existing open application for the next scenario
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
    Then verify that Business Premises YesNo screen is displayed

  @Sprint3
  Scenario: CUICE-6174 >> ATC-001: Test if user is able to see Yes No buttons and its default state
    Given that user is on Business Premises YesNo screen
    Then verify that Business Premises header "Does your business own a premises?" is displayed
    And verify that Yes button is displayed on lending question screen
    And verify that No button is displayed on lending question screen
    And verify that Yes button is not selected on lending question screen
    And verify that No button is not selected on lending question screen

  @Sprint3 @Sprint5
  Scenario: CUICE-6174 >> ATC-002: Test if user clicks on No, Questions screen is displayed
    Given that user is on Business Premises YesNo screen
    When user clicks on No button on lending question screen
    Then verify that Declined Payment YesNo screen is displayed
    And user clicks on back button on lending question screen

  @Sprint5
  Scenario: CUICE-6174,CUICE-544 >> ATC-003: Test if save and return is working when user clicks on Yes button
  	Given that category "SaveAndReturnPreTnC" is added for below scenarios
    Then verify that No button is selected on lending question screen
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/BusinessPremisesNo" is equals to "data/application/answers" except "dateModified" key
    #When user clicks on No button on lending question screen
    #Then verify that Declined Payment YesNo screen is displayed
    #And user clicks on back button on lending question screen
    #Then verify that No button is selected on lending question screen
    #When user call rest end point "configuration" to get and save the response
    #Then verify that expected json "lending-QnA/BusinessPremisesNo" is equals to "data/application/answers" except "dateModified" key

  @Sprint3 @Sprint5
  Scenario: CUICE-6174 >> ATC-004: Test if user clicks on Yes, Business Premises options are displayed
    Given that user is on Business Premises YesNo screen
    When user clicks on Yes button on lending question screen
    Then verify that Business Premises options screen is displayed
    And user clicks on back button on lending question screen

  @Sprint5
  Scenario: CUICE-6174,CUICE-544 >> ATC-005: Test if save and return is working when user clicks on Yes button
  	Given that category "SaveAndReturnPreTnC" is added for below scenarios
    Then verify that Yes button is selected on lending question screen
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/BusinessPremisesYes" is equals to "data/application/answers" except "dateModified" key
    #When user clicks on Yes button on lending question screen
    #Then verify that Business Premises options screen is displayed
    #And user clicks on back button on lending question screen
    #Then verify that Yes button is selected on lending question screen
    #When user call rest end point "configuration" to get and save the response
    #Then verify that expected json "lending-QnA/BusinessPremisesYes" is equals to "data/application/answers" except "dateModified" key

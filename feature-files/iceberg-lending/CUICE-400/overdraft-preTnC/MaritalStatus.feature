@MaritalStatus @Regression
Feature: Verify all functionalities related to Marital Status screen. It covers CUICE-6175

  Background: This is to add category to below scenarios
    Given that category "MaritalStatus" is added for below scenarios

  @Sprint3 @Sprint5
  Scenario: CUICE-6175 >> ATC-001: Test if user able to view  the Marital Status screen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    When user selects option 1 from Purpose of Borrowing question screen
    And user clicks on continue button on the screen
    When user selects option 3 on Residential Status screen
    And user clicks on continue button on the screen
    Then verify that Marital Status screen is displayed

  @Sprint3
  Scenario: CUICE-6175 >> ATC-002: Test if user is able to view the Marital Status lending question and its choices
    Given user is on Marital Status lending question screen
    Then verify that Marital Status description "What is your marital status?" on screen
    And verify that below Marital Status options are displayed
      | Civil partnership                   |
      | Married                             |
      | Divorced/Ex-civil partnership       |
      | Separated                           |
      | Single                              |
      | Living with partner                 |
      | Widowed/Surviving civil partnership |
      | Other                               |
    And verify that none of the Marital Status is pre selected
    And verify that continue button is disabled

  @Sprint3
  Scenario: CUICE-6175 >> ATC-003: Test if user is able to select any one of the choices on the Marital Status screen
    Given user is on Marital Status lending question screen
    When user selects option 1 on Marital Status screen
    Then verify that continue button is enabled

  @Sprint3
  Scenario: CUICE-6175 >> ATC-004: Test if user is able to select only one of the choices on the Marital Status screen
    Given user is on Marital Status lending question screen
    When user selects option 1 on Marital Status screen
    And user selects option 2 on Marital Status screen
    Then verify that option 1 on Marital Status is deselected
    And verify that continue button is enabled

  @Sprint3 @Sprint5
  Scenario: CUICE-6175 >> ATC-005: Test if user is able to navigate to the next screen when continue button is clicked
    Given user is on Marital Status lending question screen
    When user selects option 3 on Marital Status screen
    And user clicks on continue button on the screen
    Then verify that Gross Income screen is displayed
    And user clicks on back button on lending question screen
  
  @Sprint5
  Scenario: CUICE-6175 >> ATC-006: Test if save and return is working when user select option on Marital Status screen
  	Given that category "SaveAndReturnPreTnC" is added for below scenarios
    Then verify that option 3 on Marital Status is selected
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/MaritalStatusOpt3" is equals to "data/application/answers" except "dateModified" key
    When user selects option 4 on Marital Status screen
    And user clicks on continue button on the screen
    Then verify that Gross Income screen is displayed
    And user clicks on back button on lending question screen
    Then verify that option 4 on Marital Status is selected
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/MaritalStatusOpt4" is equals to "data/application/answers" except "dateModified" key

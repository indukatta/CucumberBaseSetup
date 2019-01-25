@ResidentialStatus @Regression
Feature: Verify all functionalities related to Residential Status screen. It will covers following stories CUICE-6175

  Background: This is to add category to below scenarios
    Given that category "ResidentialStatus" is added for below scenarios

  @Sprint3
  Scenario: CUICE-8934 >> ATC-001: Test if user able to view  the Residential Status screen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    When user selects option 1 from Purpose of Borrowing question screen
    And user clicks on continue button on the screen
    Then verify that Residential Status screen is displayed

  @Sprint3
  Scenario: CUICE-8934 >> ATC-002: Test if user is able to view the Residential Status lending question and its choices
    Given user is on Residential Status lending question screen
    Then verify that Residential Status description "What is your residential status?" on screen
    And verify that below Residential Status options are displayed
      | Halls of residence   |
      | Living with a parent |
      | Owner occupier       |
      | Tenant               |
      | Other                |
    And verify that none of the Residential Status is pre selected
    And verify that continue button is disabled

  @Sprint3
  Scenario: CUICE-8934 >> ATC-003: Test if user is able to select any one of the choices on the Residential Status screen
    Given user is on Residential Status lending question screen
    When user selects option 1 on Residential Status screen
    Then verify that continue button is enabled

  @Sprint3
  Scenario: CUICE-8934 >> ATC-004: Test if user is able to select only one of the choices on the Residential Status screen
    Given user is on Residential Status lending question screen
    When user selects option 1 on Residential Status screen
    And user selects option 2 on Residential Status screen
    Then verify that option 1 on Residential Status screen is deselected
    And verify that continue button is enabled

  @Sprint3
  Scenario: CUICE-8934 >> ATC-005: Test if user is able to navigate to the next screen when continue button is clicked
    Given user is on Residential Status lending question screen
    When user selects option 3 on Residential Status screen
    And user clicks on continue button on the screen
    Then verify that Marital Status screen is displayed
    And user clicks on back button on lending question screen

  @Sprint5
  Scenario: CUICE-TBD >> ATC-TBD: Test if save and return is working when user selects an option on Residential Status screen
    Then verify that option 3 on Residential Status screen is selected
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/ResidentialStatusOpt3" is equals to "data/application/answers" except "dateModified" key
    When user selects option 4 on Residential Status screen
    And user clicks on continue button on the screen
    Then verify that Marital Status screen is displayed
    And user clicks on back button on lending question screen
    Then verify that option 4 on Residential Status screen is selected
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/ResidentialStatusOpt4" is equals to "data/application/answers" except "dateModified" key

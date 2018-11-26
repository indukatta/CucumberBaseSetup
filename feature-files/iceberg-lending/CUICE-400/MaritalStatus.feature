@maritalStatus
Feature: Verify all functionalities related to Marital Status screen. It will covers following stories CUICE-6175

  Background: This is to add category to below scenarios
	Given that category "MaritalStatus" is added for below scenarios
	
  Scenario: CUICE-6175 >> ATC-001: Test if user able to view  the Marital Status screen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link

  Scenario: CUICE-6175 >> ATC-002: Test if user is able to view the Marital Status lending question and its choices
    Given user is on Marital Status lending question screen
    Then verify that Marital Status description "What is your marital status?" on screen
    And verify that below Marital Status options are displayed
      | Civil partnership                    |
      | Divorced/Ex-civil partnership        |
      | Living with partner                  |
      | Married                              |
      | Separated                            |
      | Single                               |
      | Widowed/Surviving Civil Ppartnership |
      | Other                                |
    And verify that none of the options are pre selected
    And verify that continue button is disabled

  Scenario: CUICE-6175 >> ATC-003: Test if user is able to select any one of the choices on the Marital Status screen
    Given user is on Marital Status lending question screen
    When user clicks on Civil partnership option on Marital Status screen
    Then verify that continue button is enabled

  Scenario: CUICE-6175 >> ATC-004: Test if user is able to select only one of the choices on the Marital Status screen
    Given user is on Marital Status lending question screen
    When user clicks on Civil partnership option on Marital Status screen
    And user clicks on Married option on Marital Status screen
    Then verify that Civil partnership option is deselected
    And verify that continue button is enabled
    
  Scenario: CUICE-6175 >> ATC-005: Test if user is able to navigate to the next screen when continue button is clicked
    Given user is on Marital Status lending question screen
    When user clicks on Single option on Marital Status screen
    And user clicks on continue button on the screen
    Then verify that Gross Income screen is displayed
    
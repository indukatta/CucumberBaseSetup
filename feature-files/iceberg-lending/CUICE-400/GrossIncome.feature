@grossIncome
Feature: Verify all functionalities related to Purpose of Borrowing screen, it will cover following stories

  Background: This is to add category to below scenarios
	Given that category "GrossIncome" is added for below scenarios
	
  Scenario: CUICE-6173 >> Pre-requisite: Test if user is able to view Gross Income screen
    Given that user is on the Credit Management screen
    Then user clicks on the Credit & Lending link
    Then user clicks on Apply button on Product Selection
    When user selects option 1 from Purpose of Borrowing Question
    And user clicks on continue button on the screen
    Then verify that Business Premises YesNo screen is displayed
    When user clicks on No button on Business Premises screen
    Then verify that Gross Income screen is displayed

  Scenario: CUICE-6173 >> ATC-001: Test if user is able to view Gross Income header and other components
    Given that user is on Gross Income screen
    Then verify that Gross Income header is displayed
    And verify that Gross Income input box is displayed
    And verify that default value of Gross Income is "0"
    And verify that currency symbol "GBP" is displayed
    And verify that continue button is disabled

  Scenario: CUICE-6173 >> ATC-002: Test if user is able to view Gross Income header and other components
    Given that user is on Gross Income screen
    When user enters minimum value "0" in Gross Income input box
    Then verify that continue button is enabled

  Scenario: CUICE-6173 >> ATC-003: Test if user is able to view Gross Income header and other components
    Given that user is on Gross Income screen
    When user enters maximum value "100000000" in Gross Income input box
    Then verify that continue button is enabled

  Scenario: CUICE-6173 >> ATC-004: Test if user is able to view Gross Income header and other components
    Given that user is on Gross Income screen
    When user enters minimum value "-1" in Gross Income input box
    Then verify that value of Gross Income is set to "1" min limit
    And verify that continue button is enabled

  Scenario: CUICE-6173 >> ATC-005: Test if user is able to view Gross Income header and other components
    Given that user is on Gross Income screen
    When user enters minimum value "100000000" in Gross Income input box
    Then verify that value of Gross Income is set to "100000000" max limit
    And verify that continue button is enabled

  Scenario: CUICE-6173 >> ATC-006: Test if user is able to view Gross Income header and other components
    Given that user is on Gross Income screen
    When user enters alphabetical and special chars "~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?" in Gross Income input box
    Then verify that value of Gross Income is set to "0" min limit
    And verify that continue button is disabled

@grossIncome
Feature: Verify all functionalities related to Purpose of Borrowing screen, it will cover following stories

  Scenario: CUICE-6274 >> ATC-001: Test if user is able to view Gross Income screen
    Given that user is on Product Selection screen
    When user clicks on Apply button on Product Selection
    Then verify that screen title "Borrowing" is displayed.
    And verify that Gross Income screen is displayed

  Scenario: CUICE-6173 >> ATC-001: Test if user is able to view Gross Income header and other components
    Given that user is on Gross Income screen
    Then verify that Gross Income header is displayed
    And verify that Gross Income inputbox is displayed
    And verify that default value of Gross Income is "0.00"
    And verify that currency symblol "GBP" is diplayed
    And verify that continue button is disabled

  Scenario: CUICE-6173 >> ATC-001: Test if user is able to view Gross Income header and other components
    Given that user is on Gross Income screen
    When user enters minimum value "0" in Gross Income input box
    And vefify that warning message is not displayed
    Then verify that continue button is enabled

  Scenario: CUICE-6173 >> ATC-001: Test if user is able to view Gross Income header and other components
    Given that user is on Gross Income screen
    When user enters maximum value "100,000,000" in Gross Income input box
    And vefify that warning message is not displayed
    Then verify that continue button is enabled

  Scenario: CUICE-6173 >> ATC-001: Test if user is able to view Gross Income header and other components
    Given that user is on Gross Income screen
    When user enters minimum value "-1" in Gross Income input box
    Then verify that value of Gross Income is set to "0" min limit
    And verify that continue button is enabled

  Scenario: CUICE-6173 >> ATC-001: Test if user is able to view Gross Income header and other components
    Given that user is on Gross Income screen
    When user enters minimum value "100,000,001" in Gross Income input box
    Then verify that value of Gross Income is set to "100,000,000" max limit
    And verify that continue button is enabled

  Scenario: CUICE-6173 >> ATC-001: Test if user is able to view Gross Income header and other components
    Given that user is on Gross Income screen
    When user enters alphabetical and special chars "~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?" in Gross Income input box
    Then verify that value of Gross Income is set to "0" min limit
    And verify that continue button is disabled

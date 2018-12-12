@TotalExistingBorrowing @Sprint4 @Regression
Feature: Verify all functionalities related to Amount of Borrowing No screen, it covers CUICE-6171

  Background: This is to add category to below scenarios
	Given that category "TotalExistingBorrowing" is added for below scenarios
	
  Scenario: CUICE-6171 >> Prerequisite: Test if user able to view  the Borrowings Yes No screen
Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    When user selects option 1 from Purpose of Borrowing Question
    And user clicks on continue button on the screen
    When user selects option 3 on Residential Status screen
    And user clicks on continue button on the screen
    When user selects option 3 on Marital Status screen
    And user clicks on continue button on the screen
    When user enters minimum value "1" in Gross Income input box
    And user clicks on continue button on the screen
    When user clicks on No button on lending question screen
    When user clicks on Yes button on lending question screen
    When user clicks on Yes button on lending question screen
    When user clicks on Yes button on lending question screen
    Then verify that Total Existing Borrowings screen is displayed
  
  Scenario: CUICE-6173 >> ATC-001: Test if user is able to view Total Existing Borrowings header and other components
    Given that user is on Total Existing Borrowings screen
    Then verify that Total Existing Borrowings question "What is your business' total existing borrowings?" is displayed
    And verify that Total Existing Borrowings input box is displayed
    And verify that default value of Total Existing Borrowings is "0"
    And verify that currency symbol "GBP" is displayed
    And verify that continue button is disabled

  Scenario: CUICE-6173 >> ATC-002: Test if user is able to view Total Existing Borrowings header and other components
    Given that user is on Total Existing Borrowings screen
    When user enters minimum value "0" in Total Existing Borrowings input box
    Then verify that continue button is enabled

  Scenario: CUICE-6173 >> ATC-003: Test if user is able to view Total Existing Borrowings header and other components
    Given that user is on Total Existing Borrowings screen
    When user enters maximum value "100000000" in Total Existing Borrowings input box
    Then verify that continue button is enabled

  Scenario: CUICE-6173 >> ATC-004: Test if user is able to view Total Existing Borrowings header and other components
    Given that user is on Total Existing Borrowings screen
    When user enters minimum value "-1" in Total Existing Borrowings input box
    Then verify that value of Total Existing Borrowings is set to "1" min limit
    And verify that continue button is enabled

  Scenario: CUICE-6173 >> ATC-005: Test if user is able to view Total Existing Borrowings header and other components
    Given that user is on Total Existing Borrowings screen
    When user enters maximum value "100000001" in Total Existing Borrowings input box
    Then verify that value of Total Existing Borrowings is set to "10000000" max limit
    And verify that continue button is enabled

  Scenario: CUICE-6173 >> ATC-006: Test if user is able to view Total Existing Borrowings header and other components
    Given that user is on Total Existing Borrowings screen
    When user enters alphabetical and special chars "~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?" in Total Existing Borrowings input box
    Then verify that value of Total Existing Borrowings is set to "0" min limit
    And verify that continue button is disabled
    
  Scenario: CUICE-6173 >> ATC-007: Test if user is able to navigate to the next screen when continue button is clicked
    Given that user is on Total Existing Borrowings screen
    When user enters minimum value "1" in Total Existing Borrowings input box
    And user clicks on continue button on the screen
    Then verify that SustainabilityCheck screen is displayed
    And user clicks on back button on lending question screen
        
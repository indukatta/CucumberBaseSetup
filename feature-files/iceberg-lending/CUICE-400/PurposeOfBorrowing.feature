@PurposeOfBorrowing @Sprint3 @Regression
Feature: Verify all functionalities related to Purpose of Borrowing screen, it will cover following stories

  Background: This is to add category to below scenarios
	Given that category "PurposeOfBorrowing" is added for below scenarios
  
  Scenario: CUICE-6173 >> Prerequisite: Test if user is able to view "What is the purpose of borrowing" header and "Borrowing" title
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    Then verify that Purpose of Borrowing screen is displayed
  	
  Scenario: CUICE-6173 >> ATC-002: Test if user is able to view the "What is the purpose of borrowing?" - Choices
    Given that user is on Purpose of Borrowing screen
    Then verify Purpose of Borrowing title "Borrowing" on screen
    And verify Purpose of Borrowing question "What is the purpose of borrowing?" on screen
    Then verify that following Purpose of Business questions are displayed on screen
      | Asset purchase                     |
      | Debt consolidation (HSBC)          |
      | Debt consolidation (non-HSBC)      |
      | Furniture & fittings               |
      | Motor vehicles                     |
      | Premises expansion                 |
      | Premises refurbishment             |
      | Property purchase - Investment     |
      | Property purchase - own occupation |
      | Stock purchase                     |
      | Working capital                    |
      | Other                              |
  
  Scenario: CUICE-6173 >> ATC-003: Test if Continue button is disabled and no option is selected by default
    Given that user is on Purpose of Borrowing screen
    Then verify that continue button is disabled
    And verify that no option is pre-selected
  
  Scenario: CUICE-6173 >> ATC-004: Test if Continue button is enabled if one option is selected
    Given that user is on Purpose of Borrowing screen
    When user selects option 2 from Purpose of Borrowing Question
    Then verify that continue button is enabled
    When user selects option 2 from Purpose of Borrowing Question
    Then verify that continue button is disabled
  
  Scenario: CUICE-6173 >> ATC-005: Test if Continue button is enabled if all options are selected
    Given that user is on Purpose of Borrowing screen
    When user selects all options from Purpose of Borrowing Question
    Then verify that continue button is enabled
    Then user selects all options from Purpose of Borrowing Question
    Then verify that continue button is disabled

  Scenario: CUICE-6173 >> ATC-006: Test if user is taken to the "Residential Status" lending question when clicked on Continue button.
    Given that user is on Purpose of Borrowing screen
    When user selects option 1 from Purpose of Borrowing Question
    And user clicks on continue button on the screen
    Then verify that Residential Status screen is displayed
    Then user clicks on back button on lending question screen
  
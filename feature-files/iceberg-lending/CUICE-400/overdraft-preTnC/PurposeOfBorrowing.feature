@PurposeOfBorrowing @Regression
Feature: Verify all functionalities related to Purpose of Borrowing screen, it covers CUICE-6173, CUICE-544

  Background: This is to add category to below scenarios
    Given that category "PurposeOfBorrowing" is added for below scenarios

  @Sprint3 @Sprint5
  Scenario: CUICE-6173 >> Prerequisite: Test if user is able to view "What is the main purpose of borrowing" header and "Borrowing" title
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    Then verify that Purpose of Borrowing screen is displayed

  @Sprint3
  Scenario: CUICE-6173 >> ATC-002: Test if user is able to view the "What is the main purpose of borrowing?" - Choices
    Given that user is on Purpose of Borrowing screen
    Then verify Purpose of Borrowing title "Borrowing" on screen
    And verify Purpose of Borrowing question "What is the main purpose of borrowing?" on screen
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

  @Sprint3
  Scenario: CUICE-6173 >> ATC-003: Test if Continue button is disabled and no option is selected by default
    Given that user is on Purpose of Borrowing screen
    Then verify that continue button is disabled
    And verify that no option is pre-selected

  @Sprint3
  Scenario: CUICE-6173 >> ATC-004: Test if Continue button is enabled if one option is selected
    Given that user is on Purpose of Borrowing screen
    When user selects option 2 from Purpose of Borrowing question screen
    Then verify that continue button is enabled

  @Sprint3 @Sprint5
  Scenario: CUICE-6173 >> ATC-005: Test if user is taken to the Residential Status lending question when clicked on Continue button.
    Given that user is on Purpose of Borrowing screen
    When user selects option 4 from Purpose of Borrowing question screen
    And user clicks on continue button on the screen
    Then verify that Residential Status screen is displayed
    Then user clicks on back button on lending question screen

  @Sprint5
  Scenario: CUICE-6173,CUICE-544 >> ATC-006: Test if save and return is working when user selects an option on Purpose of Borrowing screen
  	Given that category "SaveAndReturnPreTnC" is added for below scenarios
    Then verify that option 4 is selected on Purpose of Borrowing question screen
    When user call rest end point "question-configuration" to get and save the response
    Then verify that expected json "lending-QnA/PurposeOfBorrowingOpt4" is equals to "data/application/answers" except "dateModified" key
    When user selects option 3 from Purpose of Borrowing question screen
    And user clicks on continue button on the screen
    Then verify that Residential Status screen is displayed
    Then user clicks on back button on lending question screen
    Then verify that option 3 is selected on Purpose of Borrowing question screen
    When user call rest end point "question-configuration" to get and save the response
    Then verify that expected json "lending-QnA/PurposeOfBorrowingOpt3" is equals to "data/application/answers" except "dateModified" key

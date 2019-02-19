@TotalExistingBorrowing @Regression
Feature: Verify all functionalities related to Amount of Borrowing No screen, it covers CUICE-6255, CUICE-544

  Background: This is to add category to below scenarios
    Given that category "TotalExistingBorrowing" is added for below scenarios

  @Sprint4 @Sprint5
  Scenario: CUICE-6255 >> Prerequisite: Test if user able to view  the Borrowings Yes No screen
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
    When user enters minimum value "10000" in Gross Income input box
    And user clicks on continue button on the screen
    When user clicks on No button on lending question screen
    When user clicks on No button on lending question screen
    When user clicks on Yes button on lending question screen
    When user clicks on Yes button on lending question screen
    When user clicks on Yes button on lending question screen
    Then verify that Total Existing Borrowings screen is displayed

  @Sprint4
  Scenario: CUICE-6255 >> ATC-001: Test if user is able to view Total Existing Borrowings header and other components
    Given that user is on Total Existing Borrowings screen
    Then verify that Total Existing Borrowings question "What is your business’ total existing borrowings?" is displayed
    And verify that Total Existing Borrowings input box is displayed
    And verify that default value of Total Existing Borrowings is ""
    And verify that currency symbol "GBP" is displayed
    And verify that continue button is disabled

  @Sprint4
  Scenario: CUICE-6255 >> ATC-002: Test if user is able to view min default value in Total Existing Borrowings
    Given that user is on Total Existing Borrowings screen
    When user enters minimum value "0" in Total Existing Borrowings input box
    Then verify that continue button is disabled

  @Sprint4
  Scenario: CUICE-6255 >> ATC-003: Test if continue button is enabled if min value is entered in Total Existing Borrowings
    Given that user is on Total Existing Borrowings screen
    When user enters minimum value "1" in Total Existing Borrowings input box
    Then verify that continue button is enabled

  @Sprint4
  Scenario: CUICE-6255 >> ATC-004: Test if continue button is enabled if max value is entered in Total Existing Borrowings
    Given that user is on Total Existing Borrowings screen
    When user enters maximum value "100000000" in Total Existing Borrowings input box
    Then verify that continue button is enabled

  @Sprint4
  Scenario: CUICE-6255 >> ATC-005: Test if continue button is enabled and set to min default value if minus value is entered in Total Existing Borrowings
    Given that user is on Total Existing Borrowings screen
    When user enters minimum value "-1" in Total Existing Borrowings input box
    Then verify that value of Total Existing Borrowings is set to "1" min limit
    And verify that continue button is enabled

  @Sprint4
  Scenario: CUICE-6255 >> ATC-006: Test if continue button is enabled and set to max default value if more value is entered in Total Existing Borrowings
    Given that user is on Total Existing Borrowings screen
    When user enters maximum value "100000001" in Total Existing Borrowings input box
    Then verify that value of Total Existing Borrowings is set to "10000000" max limit
    And verify that continue button is enabled

  @Sprint4
  Scenario: CUICE-6255 >> ATC-007: Test if continue button is disabled and set to default value if special characters are entered in Total Existing Borrowings
  	Given that category "SaveAndReturnPreTnC" is added for below scenarios
    Given that user is on Total Existing Borrowings screen
    When user enters alphabetical and special chars "~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?" in Total Existing Borrowings input box
    Then verify that value of Total Existing Borrowings is set to "1" min limit
    And verify that continue button is disabled

  @Sprint4 @Sprint5
  Scenario: CUICE-6255 >> ATC-008: Test if user is able to navigate to the next screen when continue button is clicked
    Given that user is on Total Existing Borrowings screen
    When user enters minimum value "101" in Total Existing Borrowings input box
    And user clicks on continue button on the screen
    Then verify that SustainabilityCheck screen is displayed
    And user clicks on back button on lending question screen

  @Sprint5
  Scenario: CUICE-6255,CUICE-544 >> ATC-009: Test if save and return is working when user enters value in Total Existing Borrowings screen
  	Given that category "SaveAndReturnPreTnC" is added for below scenarios
    Then verify that Total Existing Borrowings is equals to "101" entered value
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/TotalExistingBorrowing101" is equals to "data/application/answers" except "dateModified" key
    When user enters minimum value "1001" in Total Existing Borrowings input box
    And user clicks on continue button on the screen
    Then verify that SustainabilityCheck screen is displayed
    And user clicks on back button on lending question screen
    Then verify that Total Existing Borrowings is equals to "1001" entered value
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/TotalExistingBorrowing1001" is equals to "data/application/answers" except "dateModified" key

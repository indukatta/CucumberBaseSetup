@maritalStatus
Feature: Verify all functionalities related to Marital Status screen. It will covers following stories CUICE-6175

  Background: This is to add category to below scenarios
    Given that category "AmountOfBorrowing" is added for below scenarios

  Scenario: CUICE-6171 >> Prerequisite: Test if user able to view the Amount of Borrowing screen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    When user clicks on Apply button on Product Selection
    When user selects option 1 from Purpose of Borrowing Question
    When user clicks on continue button on the screen
    Then user clicks on No button on Business Premises screen
    When user enters minimum value "100" in Gross Income input box
    And user clicks on continue button on the screen
    Then verify that Marital Status screen is displayed

  Scenario: CUICE-6171 >> ATC-001: Test if user is able to view the Amount of Borrowing screen and its components
    Given user is on Amount of Borrowing question screen
    Then verify Amount of Borrowing screen header "How much would you like to borrow?" on screen
    And verify that suggession below to Amount of Borrowing screen header
    And verify that Amount of borrowing slider is displayed on the screen                                |
    And verify that monthly fee component "Fee GBP 8 monthly" is displayed on the screen
    And verify that EAR component "Representative EAR of 9.9% variable*" is displayed on the screen
    And verify that continue button is disabled

  Scenario Outline: CUICE-6171 >> ATC-002: Test if monthly fee changes as per Amount of Borrowing selected on screen
    Given user is on Amount of Borrowing question screen
    When user selects an amount <Amount of Borrowing> on Amount of Borrowig screen
    Then verify that monthly fee <Monthly Fee> is calculated and corrent on the screen
    Then verify that continue button is enabled

    Examples: 
      | Amount of Borrowing | Monthly Fee |
      |                 100 |       0.125 |
      |                 500 |       0.625 |
      |                1000 |        1.25 |
      |               10000 |       10.25 |

  Scenario: CUICE-6171 >> ATC-004: Test if user is able to select only one of the choices on the Marital Status screen
    Given user is on Amount of Borrowing question screen
    When user selects option on Amount of Borrowig screen
    And user clicks on continue button on the screen
    Then verify that Purpose of Borrowing screen is displayed
    Then user clicks on back button on Purpose of Borrowing screen

  Scenario: CUICE-6171 >> ATC-005: Test if user is able to navigate to the next screen when continue button is clicked
    Given user is on Marital Status lending question screen
    When user selects option 3 on Marital Status screen
    And user clicks on continue button on the screen
    Then verify that Residential Status is displayed
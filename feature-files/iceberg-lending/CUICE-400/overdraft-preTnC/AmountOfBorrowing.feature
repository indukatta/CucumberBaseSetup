@AmountOfBorrowings @Regression
Feature: Verify all functionalities related to Amount of Borrowing  screen, it covers CUICE-6171

  Background: This is to add category to below scenarios
    Given that category "AmountOfBorrowings" is added for below scenarios

  @Sprint4
  Scenario: CUICE-6171 >> Prerequisite: Test if user able to view  the Borrowings Yes No screen
    Given that user is on the Credit Management screen
    Then close existing open application for the next scenario
    When user clicks on the Credit & Lending link
    And user clicks on Apply button on Product Selection
    And user clicks on Yes button on lending question screen
    Then verify that Amount of Borrowing screen is displayed

  @Sprint4
  Scenario: CUICE-6171 >> ATC-006: Test if user is able to view the Amount of Borrowing  screen and its components
    Given user is on Amount of Borrowing question screen
    Then verify Amount of Borrowing title "Borrowing" on screen
    Then verify Amount of Borrowing question "How much would you like to borrow?" on screen
    And verify that Amount of borrowing slider is displayed on the screen
    And verify that monthly fee component "Fee 0.12 GBP monthly" is displayed on the screen
    And verify that EAR component "Representative EAR of 9.9% variable*" is displayed on the screen
    And verify that desclaimer "*All lending is subject to eligibility" is displayed on the screen
    And verify that continue button is disabled

  @Sprint4
  Scenario Outline: CUICE-6171 >> MTC-007: Test if monthly fee changes as per Amount of Borrowing selected on screen
    Given user is on Amount of Borrowing question screen
    When user selects an amount <Amount of Borrowing> on Amount of Borrowing Yes screen
    Then verify that monthly fee <Monthly Fee> is calculated and correct on the screen
    Then verify that continue button is enabled

    Examples: 
      | Amount of Borrowing | Monthly Fee |
      |                1000 |        0.62 |
      |                1500 |        1.87 |
      |                4000 |        0.62 |
      |                5500 |       11.25 |
      |                7000 |       11.25 |

  @Sprint4
  Scenario: CUICE-6171 >> ATC-008: Test if user is able to purpose of borrowing screen after clicking on Yes
    Given user is on Amount of Borrowing question screen
    Then user clicks on continue button on the screen
    Then verify that Purpose of Borrowing screen is displayed
    And user clicks on back button on lending question screen

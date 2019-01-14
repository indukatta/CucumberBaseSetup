
Feature: Verify all functionalities related to Amount of Borrowings Yes No screen, it covers CUICE-6171

  Background: This is to add category to below scenarios
	Given that category "AmountOfBorrowingYesNo" is added for below scenarios
  
  @SaveLendingQuestions
  Scenario: CUICE-6171 >> Prerequisite: Test if user able to view  the Amount of Borrowings Yes No screen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    When user clicks on Apply button on Product Selection
    Then verify that Amount of Borrowing YesNo screen is displayed
    Then user exit the iceberg application and reopen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    
  Scenario: CUICE-6171 >> ATC-001: Test if user is able to see header, Yes No buttons and its default state
    Given that user is on Amount of Borrowing YesNo screen
    Then verify that Amount of Borrowing title "Borrowing" on screen
    Then verify that Amount of Borrowing question "Do you know how much you would like to borrow?" on screen
    And verify that Yes button is displayed on lending question screen
    And verify that No button is displayed on lending question screen
  	And verify that Yes button is not selected on lending question screen
  	And verify that No button is not selected on lending question screen
  	
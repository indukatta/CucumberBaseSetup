@AmountOfBorrowingNo @Sprint4 @Regression
Feature: Verify all functionalities related to Amount of Borrowing No screen, it covers CUICE-6171

  Background: This is to add category to below scenarios
	Given that category "AmountOfBorrowingNo" is added for below scenarios
	
  Scenario: CUICE-6171 >> Prerequisite: Test if user able to view  the Borrowings Yes No screen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    Then verify that Amount of Borrowing No screen is displayed
  
  Scenario: CUICE-6171 >> ATC-004: Test if user is able to see default message on the screen and Okay button
    Given that user is on Amount of Borrowing No screen
    Then verify Amount of Borrowing No title "Borrowing" on screen
    Then verify Amount of Borrowing No message "We'll let you know how much your business can borrow at the end of the application process" on screen
    And verify that continue button is enabled
  	
  Scenario: CUICE-6171 >> ATC-005: Test if user clicks on Okay Got it button, Purpose of Borrowing screen is displayed
    Given that user is on Amount of Borrowing No screen
    When user clicks on continue button on the screen
    Then verify that Purpose of Borrowing screen is displayed
    And user clicks on back button on lending question screen
        
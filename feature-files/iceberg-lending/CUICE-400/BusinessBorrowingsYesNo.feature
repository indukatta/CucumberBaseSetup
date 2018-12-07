@maritalStatus
Feature: Verify all functionalities related to Borrowing Yes No screen, it covers CUICE-6255

  Background: This is to add category to below scenarios
	Given that category "BorrowingYesNo" is added for below scenarios
	
  Scenario: CUICE-6255 >> Prerequisite: Test if user able to view  the Borrowings Yes No screen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    When user clicks on Apply button on Product Selection
    When user selects option 1 from Purpose of Borrowing Question
    When user clicks on continue button on the screen
    Then user clicks on No button on Business Premises screen
    When user enters minimum value "100" in Gross Income input box
    And user clicks on continue button on the screen
    Then verify that Marital Status screen is displayed
  
  Scenario: CUICE-6174 >> ATC-001: Test if user is able to see Yes No buttons and its default state
    Given that user is on Business Borrowing YesNo screen
    Then verify that Borrowing header "Does your business have any borrowings?" is displayed
    And verify that Yes button is displayed on Business Premises screen
    And verify that No button is displayed on Business Premises screen
  	And verify that Yes button is not selected on Business Premises screen
  	And verify that No button is not selected on Business Premises screen
  	And verify that message is displayed below Yes No button on screen
  	
  Scenario: CUICE-6174 >> ATC-002: Test if user clicks on No, Questions screen is displayed
    Given that user is on Business Borrowing YesNo screen
    When user clicks on No button on Business Premises screen
    Then verify that Business Premises options screen is displayed
    Then verify that Gross Income screen is displayed
    And user clicks on back button on the screen
    
  Scenario: CUICE-6174 >> ATC-003: Test if user clicks on Yes, Business Premises options are displayed
    Given that user is on Business Borrowing YesNo screen
    When user clicks on Yes button on Business Premises screen
    Then verify that Business Premises options screen is displayed
    And user clicks on back button on the screen
    
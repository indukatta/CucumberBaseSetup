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

  Scenario: CUICE-6255 >> ATC-001: Test if user is able to view the Marital Status lending question and its choices
    Given user is on Amount of Borrowing question screen
    Then verify that Borrowing YesNo header "Does the business have any borrowings?" is displayed
    And verify that Yes button is displayed on Borrowing YesNo screen
    And verify that No button is displayed on Borrowing YesNo screen
  	And verify that Yes button is not selected on Borrowing YesNo screen
  	And verify that No button is not selected on Borrowing YesNo screen

  Scenario: CUICE-6175 >> ATC-003: Test if user is able to select any one of the choices on the Marital Status screen
    Given user is on Amount of Borrowing question screen
    When user selects option 1 on Marital Status screen
    Then verify that continue button is enabled

  Scenario: CUICE-6175 >> ATC-004: Test if user is able to select only one of the choices on the Marital Status screen
    Given user is on Amount of Borrowing question screen
    When user selects option 1 on Marital Status screen
    And user selects option 2 on Marital Status screen
    Then verify that option 1 on Marital Status is deselected
    And verify that continue button is enabled
    
  Scenario: CUICE-6175 >> ATC-005: Test if user is able to navigate to the next screen when continue button is clicked
    Given user is on Amount of Borrowing question screen
    When user selects option 3 on Marital Status screen
    And user clicks on continue button on the screen
    Then verify that Residential Status is displayed
    
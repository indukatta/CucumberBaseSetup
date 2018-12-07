@businessPremisesYN
Feature: Verify all functionalities related to Business Premises Yes/No screen, it will cover following stories

  Background: This is to add category to below scenarios
	Given that category "BusinessPremisesYesNo" is added for below scenarios
	
  Scenario: CUICE-6174 >> ATC-001: Test if user is able to view "What is the purpose of borrowing" header and "Borrowing" title
    Given that user is on the Credit Management screen
    Then user clicks on the Credit & Lending link
    Then user clicks on Apply button on Product Selection
    When user selects option 1 from Purpose of Borrowing Question
    And user clicks on continue button on the screen
    Then verify that Business Premises YesNo screen is displayed
  
  Scenario: CUICE-6174 >> ATC-001: Test if user is able to see Yes No buttons and its default state
    Given that user is on Business Premises YesNo screen
    Then verify that Business Premises header "Does your business own a premises?" is displayed
    And verify that Yes button is displayed on Business Premises screen
    And verify that No button is displayed on Business Premises screen
  	And verify that Yes button is not selected on Business Premises screen
  	And verify that No button is not selected on Business Premises screen
  	And verify that Information is displayed
  	
  Scenario: CUICE-6174 >> ATC-002: Test if user clicks on No, Questions screen is displayed
    Given that user is on Business Premises YesNo screen
    Then verify that Business Premises header "Does your business own a premises?" is displayed
    And verify that Yes button is displayed on Business Premises screen
    And verify that No button is displayed on Business Premises screen
  	And verify that Yes button is not selected on Business Premises screen
  	And verify that No button is not selected on Business Premises screen
    
  Scenario: CUICE-6174 >> ATC-003: Test if user clicks on Yes, Business Premises options are displayed
    Given that user is on Business Premises YesNo screen
    When user clicks on Yes button on Business Premises screen
    Then verify that Business Premises options screen is displayed
    And user clicks on back button on the screen


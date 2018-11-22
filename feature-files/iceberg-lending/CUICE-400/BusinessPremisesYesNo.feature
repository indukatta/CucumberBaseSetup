@businessPremises
Feature: Verify all functionalities related to Business Premises Yes/No screen, it will cover following stories

  Scenario: CUICE-6174 >> ATC-001: Test if user is able to see Business Premises question screen
    Given that user is on Product Selection screen
    When user clicks on Apply button on Product Selection
    Then verify that screen title "Borrowing" is displayed.
    And user selects an option from Purpose of Borrowing Question
    And user clicks on continue button on the screen
    Then verify that Business Premises YesNo screen is displayed

  Scenario: CUICE-6174 >> ATC-002: Test if user is able to see Yes No buttons and its default state
    Given that user is on Business Premises YesNo screen
    Then verify that Business Premises header "Does your business own a premises?" is displayed
    And verify that Yes button is displayed on Business Premises screen
    And verify that No button is displayed on Business Premises screen
  	And verify that Yes button is not selected on Business Premises screen
  	And verify that No button is not selected on Business Premises screen
  	
  Scenario: CUICE-6174 >> ATC-003: Test if user clicks on No, Questions screen is displayed
    Given that user is on Business Premises YesNo screen
    When user clicks on No button on Business Premises screen
    Then verify that Question screen is displayed
    
  Scenario: CUICE-6174 >> ATC-004: Test if user clicks on Yes, Business Premises options are displayed
    Given that user is on Business Premises YesNo screen
    When user clicks on Yes button on Business Premises screen
    Then verify that Business Premises options screen is displayed


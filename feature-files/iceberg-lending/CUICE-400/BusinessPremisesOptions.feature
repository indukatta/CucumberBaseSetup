@businessPremises
Feature: Verify all functionalities related to Purpose of Borrowing screen, it will cover following stories
  
  Background: This is to add category to below scenarios
	Given that category "BusinessPremises" is added for below scenarios

  Scenario: CUICE-6174 >> ATC-005: Test if user is able to see Business Premises options screen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    When user clicks on Apply button on Product Selection
    When user selects option 1 from Purpose of Borrowing Question
    When user clicks on continue button on the screen
    Then user clicks on Yes button on Business Premises screen
    Then verify that Business Premises options screen is displayed

  Scenario: CUICE-6174 >> ATC-006: Test if user is able to see Business Premises's default state
    Given that user is on Business Premises options screen
    Then verify that Premises Business options header "What type of premises does your business own?" is displayed
    And verify that Freehold Business Premises type "Freehold" is displayed
    And verify that Leasehold Business Premises type "Leasehold" is displayed
    And verify that non of the Business Premises type is pre selected
    And verify that continue button is disabled

  Scenario: CUICE-6174 >> ATC-007: Test if user select an option then continue button is enabled
    Given that user is on Business Premises options screen
    When user clicks on Freehold Business Premises type
    Then verify that continue button is enabled
    Then verify that Leasehold Business Premises type is not selected
    When user clicks on Leasehold Business Premises type
    Then verify that continue button is enabled
    Then verify that Freehold Business Premises type is not selected

  Scenario: CUICE-6174 >> ATC-008: Test if user select an option and clicks on Continue, Questions screen is displayed
    Given that user is on Business Premises options screen
    When user clicks on Freehold Business Premises type
    And user clicks on continue button on the screen

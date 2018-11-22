@businessPremises
Feature: Verify all functionalities related to Purpose of Borrowing screen, it will cover following stories

  Scenario: CUICE-6174 >> ATC-005: Test if user is able to see Business Premises options screen
    Given that user is on Product Selection screen
    When user clicks on Apply button on Product Selection
    Then verify that screen title "Borrowing" is displayed.
    And user selects an option from Purpose of Borrowing Question
    And user clicks on continue button on the screen
    Then verify that Business Premises options screen is displayed

  Scenario: CUICE-6174 >> ATC-006: Test if user is able to see Business Premises's default state
    Given that user is on Business Premises options screen
    Then verify that Premises Business options header "What type of premises does you business own?" is displayed
    And verify that Freehold Business Premises type is displayed
    And verify that Leasehold Business Premises type is displayed
    And verify that Freehold Business Premises type is not selected
    And verify that Leasehold Business Premises type is not selected
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
    Then verify that Question screen is displayed

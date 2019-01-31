@BusinessPremisesOptions @Regression
Feature: Verify all functionalities related to Business Premises screen, it covers CUICE-6174, CUICE-544

  Background: This is to add category to below scenarios
    Given that category "BusinessPremisesOptions" is added for below scenarios

  @Sprint3 @Sprint5
  Scenario: CUICE-6174 >> ATC-006: Test if user is able to see Business Premises options screen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    When user selects option 1 from Purpose of Borrowing question screen
    And user clicks on continue button on the screen
    When user selects option 3 on Residential Status screen
    And user clicks on continue button on the screen
    When user selects option 3 on Marital Status screen
    And user clicks on continue button on the screen
    When user enters minimum value "1000" in Gross Income input box
    And user clicks on continue button on the screen
    Then user clicks on No button on lending question screen
    Then user clicks on Yes button on lending question screen
    Then verify that Business Premises options screen is displayed

  @Sprint3
  Scenario: CUICE-6174 >> ATC-007: Test if user is able to see Business Premises's default state
    Given that user is on Business Premises options screen
    Then verify that Premises Business options header "What type of premises does your business own?" is displayed
    And verify that Freehold Business Premises type "Freehold" is displayed
    And verify that Leasehold Business Premises type "Leasehold" is displayed
    And verify that non of the Business Premises type is pre selected
    And verify that continue button is disabled

  @Sprint3
  Scenario: CUICE-6174 >> ATC-008: Test if user select an option then continue button is enabled
    Given that user is on Business Premises options screen
    When user clicks on Freehold Business Premises type
    Then verify that continue button is enabled
    Then verify that Leasehold Business Premises type is not selected
    When user clicks on Leasehold Business Premises type
    Then verify that continue button is enabled
    Then verify that Freehold Business Premises type is not selected

  @Sprint3 @Sprint5
  Scenario: CUICE-6174 >> ATC-009: Test if user select an option and clicks on Continue, Questions screen is displayed
    Given that user is on Business Premises options screen
    When user clicks on Freehold Business Premises type
    And user clicks on continue button on the screen
    Then user clicks on back button on lending question screen

  @Sprint5
  Scenario: CUICE-6174,CUICE-544 >> ATC-010: Test if save and return is working when user select Business Premisses type
    Given add category "SaveAndReturnPreTnC" again for below specific scenarios
    Then verify that Freehold Business Premises type is selected
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/BusinessPremisesFreehold" is equals to "data/application/answers" except "dateModified" key
    When user clicks on Leasehold Business Premises type
    And user clicks on continue button on the screen
    Then user clicks on back button on lending question screen
    Then verify that Leasehold Business Premises type is selected
    When user call rest end point "configuration" to get and save the response
    Then verify that expected json "lending-QnA/BusinessPremisesLeasehold" is equals to "data/application/answers" except "dateModified" key

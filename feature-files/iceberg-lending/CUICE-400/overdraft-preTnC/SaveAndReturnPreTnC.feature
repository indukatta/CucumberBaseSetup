@SaveAndReturnPreTnC @Regression
Feature: Verify all functionalities related to Amount of Borrowing No screen, it covers CUICE-544

  Background: This is to add category to below scenarios
    Given that category "SaveAndReturnPreTnC" is added for below scenarios

  @Sprint5
  Scenario: CUICE-6171 >> Prerequisite: Test if user able to view  the Borrowings Yes No screen
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
    When user clicks on No button on lending question screen
    When user clicks on No button on lending question screen
    When user clicks on Yes button on lending question screen
    When user clicks on No button on lending question screen
    Then verify that SustainabilityCheck screen is displayed
    When user clicks on Yes button on lending question screen

  @Sprint5
  Scenario: CUICE-6171 >> Logout and Login to see if values are saved for an application
    When user clicks on the More and Logout link
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    Then verify that SustainabilityCheck screen is displayed
    Then verify that Yes button is selected on lending question screen
    When user clicks on Yes button on lending question screen
    And user clicks on back button on lending question screen
    And user clicks on back button on lending question screen
    Then verify that No button is selected on lending question screen
    And user clicks on back button on lending question screen
    Then verify that Yes button is selected on lending question screen
    And user clicks on back button on lending question screen
    Then verify that No button is selected on lending question screen
    And user clicks on back button on lending question screen
    Then verify that No button is selected on lending question screen
    And user clicks on back button on lending question screen
    Then verify that entered value "1000" is displayed in Gross Income input box
    And user clicks on back button on lending question screen
    Then verify that option 3 on Marital Status is selected
    And user clicks on back button on lending question screen
    Then verify that option 3 on Residential Status screen is selected
    And user clicks on back button on lending question screen
    Then verify that option 1 is selected on Purpose of Borrowing question screen
    And user clicks on back button on lending question screen
    And user clicks on back button on lending question screen
    Then verify that No button is selected on lending question screen
    And user clicks on back button on lending question screen
    Then verify that Credit & Lending option is displayed on screen

  @Sprint5
  Scenario: CUICE-6171 >> Logout and Login to see if values are saved for an application
    When user exit the iceberg application and relaunch
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    Then verify that SustainabilityCheck screen is displayed
    Then verify that Yes button is selected on lending question screen
    Then verify that Yes button is selected on lending question screen
    When user clicks on Yes button on lending question screen
    And user clicks on back button on lending question screen
    And user clicks on back button on lending question screen
    Then verify that No button is selected on lending question screen
    And user clicks on back button on lending question screen
    Then verify that Yes button is selected on lending question screen
    And user clicks on back button on lending question screen
    Then verify that No button is selected on lending question screen
    And user clicks on back button on lending question screen
    Then verify that No button is selected on lending question screen
    And user clicks on back button on lending question screen
    Then verify that entered value "1000" is displayed in Gross Income input box
    And user clicks on back button on lending question screen
    Then verify that option 3 on Marital Status is selected
    And user clicks on back button on lending question screen
    Then verify that option 3 on Residential Status screen is selected
    And user clicks on back button on lending question screen
    Then verify that option 1 is selected on Purpose of Borrowing question screen
    And user clicks on back button on lending question screen
    And user clicks on back button on lending question screen
    Then verify that No button is selected on lending question screen

  @Sprint5
  Scenario: CUICE-6171 >> Logout and Login to see if values are saved for an application
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
    When user clicks on No button on lending question screen
    When user clicks on No button on lending question screen
    When user clicks on Yes button on lending question screen
    When user clicks on No button on lending question screen
    Then verify that SustainabilityCheck screen is displayed
    When user clicks on Yes button on lending question screen

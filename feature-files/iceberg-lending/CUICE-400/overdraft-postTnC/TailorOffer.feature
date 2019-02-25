@TailorOffer @Regression @User1
Feature: Verify all functionalities related to Tailor Offer screen, it covers CUICE-9953

  Background: This is to add category to below scenarios
    Given that category "TailorOffer" is added for below scenarios

  @Sprint6
  Scenario: CUICE-9953 >> Prerequisite: Test if user able to view  the Tailor Offer screen
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
    When user enters minimum value "3500" in Gross Income input box
    And user clicks on continue button on the screen
    When user clicks on No button on lending question screen
    When user clicks on No button on lending question screen
    When user clicks on Yes button on lending question screen
    When user clicks on No button on lending question screen
    When user clicks on No button on lending question screen
    Then verify that Terms and Conditions screen is displayed
    Then user clicks on Accept button on Terms and Conditions screen
    Then verify that Continue button on suitable offer is pre selected
    Then verify that Tailor Offer screen is visible

  @Sprint6
  Scenario: CUICE-553 >> Test if rate gets changed with amount selected on Tailor Offer screen
    Given that user is on the Tailor Offer screen
    And user change the offer amount with slider on Tailor Offer screen
    Then verify that fee has calculated correctly on Tailor Offer screen
    Then verify that continue button is enabled
  @Sprint6
  Scenario: CUICE-553 >> Test if rate gets changed with amount selected on Tailor Offer screen
    Given that user is on the Tailor Offer screen
    And user change the offer amount with keyboard on Tailor Offer screen
    Then verify that fee has calculated correctly on Tailor Offer screen
    Then verify that continue button is enabled

  @Sprint6
  Scenario: CUICE-553 >> Test if rate gets changed with amount selected on Tailor Offer screen
    Given that user is on the Tailor Offer screen
    And user change the offer amount with keyboard on Tailor Offer screen
    Then verify that fee has calculated correctly on Tailor Offer screen
    Then verify that continue button is enabled

  @Sprint6
  Scenario: CUICE-553 >> Test if rate gets changed with amount selected on Tailor Offer screen
    Given that user is on the Tailor Offer screen
    And user change the offer amount with keyboard on Tailor Offer screen
    Then verify that fee has calculated correctly on Tailor Offer screen
    Then verify that continue button is enabled

  @Sprint6
  Scenario: CUICE-553 >> Test if rate gets changed with amount selected on Tailor Offer screen
    Given that user is on the Tailor Offer screen
    When user clicks on continue button on the screen
    Then verify that the Final Offer screen is displayed
    Then verify that opted suitable offer amount is displayed on Final Offer screen
    Then verify that correct rate has been calculated on Final Offer screen
    Then user clicks on back button on lending question screen
    Given that user is on the Tailor Offer screen

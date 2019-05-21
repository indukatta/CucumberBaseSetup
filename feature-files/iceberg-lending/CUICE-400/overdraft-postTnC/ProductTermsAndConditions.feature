@ProductTermsAndConditions @Regression
Feature: Verify all functionalities related to Final Offer screen, it covers CUICE-9953

  Background: This is to add category to below scenarios
    Given that category "ProductTermsAndConditions" is added for below scenarios

  @Sprint9
  Scenario: CUICE-9953 >> Prerequisite: Test if user able to view  the Terms and Conditions screen
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "2340" for lending question
    And user selects option 1 from Purpose of Borrowing question screen
    And user clicks on continue button on the screen
    And user selects option 3 on Residential Status screen
    And user clicks on continue button on the screen
    And user selects option 3 on Marital Status screen
    And user clicks on continue button on the screen
    And user enters minimum value "6000" in Gross Income input box
    And user clicks on continue button on the screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Yes button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Accept button on Terms and Conditions screen
    Then user clicks on Continue with overdraft button on Final Offer
    Then verify that products Terms and Conditions screen is visible

  @Sprint9
  Scenario: CUICE-571 >> TC-001: Test if Accept and Not Now buttons are visible on the screen.
    Given that user is on products Terms and Conditions screen
    Then verify that product header text "Overdraft Terms and Conditions" is visible on the screen
    Then user scroll down to bottom of screen to see primary button
    Then verify that Accept display text "Accept" is visible on the screen
    Then verify that Not Now display text "Not Now" is visible on the screen
    Then verify that Accept button is enabled on product TnC screen
    Then verify that Not Now button is enabled on product TnC screen
    Then user clicks on back button on lending question screen

  @Sprint9
  Scenario: CUICE-575 >> TC-002: Test if Accept and Not Now buttons are visible on the screen.
    Given that user is on products Terms and Conditions screen
    Then user clicks on Not Now button on Terms and Conditions screen
    Then verify that Remind me Later screen is visible
    Then user clicks on back button on lending question screen

  @Sprint9
  Scenario: CUICE-571 >> TC-4608: Test if Accept and Not Now buttons are visible on the screen.
    Given that user is on products Terms and Conditions screen
    Then user clicks on Accept button on Terms and Conditions screen
    Then verify that homescreen is visible on the screen
    Then user clicks on back button on lending question screen
@TermsAndConditions @Regression
Feature: Verify all functionalities related to Amount of Borrowing No screen, it covers CUICE-552, CUICE-553

  Background: This is to add category to below scenarios
    Given that category "TermsAndConditions" is added for below scenarios

  @Sprint6
  Scenario: CUICE-552 >> Prerequisite: Test if user able to view  the Terms and Conditions screen
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
    When user clicks on the More and then Lending button
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
    Then verify that Terms and Conditions screen is displayed

  @Sprint6
  Scenario: CUICE-552 >> Test that CTA are not sticky to the screen and not visible at top
    Given that user is on the Terms and Conditions screen
    Then verify that Accept button is not visible
    Then verify that Reject button is not visible

  @Sprint6
  Scenario: CUICE-553 >> Test if CTA and help link is enabled when user scroll to bottom of screen
    Given that user is on the Terms and Conditions screen
    When user scroll down to bottom of screen
    Then captures updated screenshot for execution results
    Then verify that click here link is visible on screen
    Then verify that Accept button is pre selected and enabled
    Then verify that Reject button is not pre selected and enabled

  @Sprint6
  Scenario: CUICE-553 >> Click on No button and verify that application is not cancelled and user can't create new application
    Given that user is on the Terms and Conditions screen
    When user clicks on Reject button on Terms and Conditions screen
    When user clicks on No on Alert pop up to dismiss
    Then verify that Terms and Conditions screen is displayed
    

  @Sprint6
  Scenario: CUICE-553 >> Click on Yes button and verify that application is closed and user can create new application
    Given that user is on the Terms and Conditions screen
    When user clicks on Reject button on Terms and Conditions screen
    When user clicks on Yes on Alert pop up to dismiss
    When user clicks on the More and then Lending button
    Then verify that Product Selection screen is displayed

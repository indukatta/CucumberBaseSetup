@TermsAndConditions @Regression
Feature: Verify all functionalities related to Amount of Borrowing No screen, it covers CUICE-552, CUICE-553

  Background: This is to add category to below scenarios
    Given that category "TermsAndConditions" is added for below scenarios

  @Sprint5
  Scenario: CUICE-552 >> Prerequisite: Test if user able to view  the Terms and Conditions screen
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
    Then verify that Terms and Conditions screen is displayed

  @Sprint5
  Scenario: CUICE-552 >> Test that CTA are not sticky to the screen and not visible at top
    Given that user is on the Terms and Conditions screen
    Then verify that Accept button is not visible
    Then verify that Reject button is not visible

  @Sprint5
  Scenario: CUICE-553 >> Test if CTA and help link is enabled when user scroll to bottom of screen
    Given that user is on the Terms and Conditions screen
    When user scroll down to bottom of screen
    Then verify that help link is visible on screen
    Then verify that url "" is linked to the help text 
    Then verify that Accept button is enabled on screen
    Then verify that Reject button is enabled on screen
    
  @Sprint5
  Scenario: CUICE-553 >> Click on reject and verify that confirmation Alert is pops up
    Given that user is on the Terms and Conditions screen
    When user clicks on Reject button on Terms and Conditions screen
    Then verify that confirmation Alert is pops up on screen
    
    @Sprint5
  Scenario: CUICE-553 >> Click on No button and verify that application is not cancelled and user can't create new application
    #Given that user is on the Terms and Conditions screen
    When user clicks on Reject button on Terms and Conditions screen
    When user clicks on No to dissmiss the alret
    When user clicks on the Credit & Lending link
    Then verify that SustainabilityCheck screen is displayed
    When user clicks on Yes button on lending question screen
    
    @Sprint5
  Scenario: CUICE-553 >> Click on Yes button and verify that application is closed and user can create new application
    Given that user is on the Terms and Conditions screen
    When user clicks on Reject button on Terms and Conditions screen
    When user clicks on Yes to accept the alret
    When user clicks on the Credit & Lending link
    Then verify that Product Selection screen is displayed
    
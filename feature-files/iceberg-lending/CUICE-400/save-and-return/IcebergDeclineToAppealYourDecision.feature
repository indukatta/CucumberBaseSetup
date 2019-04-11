 @SaveAndReturnPostTnC @Regression
Feature: Verify that save and return functionality is working for Suitable Offer to Appeal your Decision flow

  Background: This is to add category to below scenarios
    Given that category "IcebergDeclineToAppealYourDecision" is added for below scenarios

  @Sprint10 @IcebergDeclineToAppealYourDecision
  Scenario: CUICE-9341 >> Prerequisite: Test if user able to view  the Iceberg Decline screen
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "3800" for lending question
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
    And user clicks on Yes button on lending question screen
    And user clicks on Accept button on Terms and Conditions screen
    Then verify that Iceberg Decline screen is displayed

  @Sprint10 @IcebergDeclineToAppealYourDecision
  Scenario: CUICE-9341 >> ATC026: Logout and Login to see if user is lending to Iceberg Decline screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Iceberg Decline screen is displayed
    Then user clicks on Next button on User decline screen
    Then verify that Alternative Financing screen is visible

  @Sprint10 @IcebergDeclineToAppealYourDecision
  Scenario: CUICE-9341 >> ATC027: Logout and Login to see if user is lending to Alternative Financing screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Alternative Financing screen is visible
    Then user clicks on I Consent on Financial Alternative screen
    Then verify that Ok got it for I Consent option is displayed

  @Sprint10 @IcebergDeclineToAppealYourDecision
  Scenario: CUICE-9341 >> ATC028: Logout and Login to see if user is lending to Alternative Financing screen after alert
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Alternative Financing screen is visible
    Then user clicks on I Consent on Financial Alternative screen
    Then user clicks on Ok got it from Alternative Financing screen
    Then verify that Appeal your Decision screen is visible

  @Sprint10
  Scenario: CUICE-9341 >> ATC029: Logout and Login to see if user is lending to Appeal your Decision screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Appeal your Decision screen is visible
    Then user clicks on Ok got it on Appleal your Decision screen

  @Sprint10
  Scenario: CUICE-9341 >> ATC033: Logout and Login to see if user is lending to Appeal your Decision screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Re-apply Overdraft screen is displayed

  @Sprint10
  Scenario: CUICE-9341 >> Prerequisite: Test if user able to view  the Iceberg Decline screen from PSE
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "8800" for lending question
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
    Then verify that Iceberg Decline screen is displayed

  @Sprint10
  Scenario: CUICE-9341 >> ATC030: Logout and Login to see if user is lending to Iceberg Decline screen from PSE
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Iceberg Decline screen is displayed
    Then user clicks on Next button on User decline screen
    Then verify that Alternative Financing screen is visible

  @Sprint10
  Scenario: CUICE-9341 >> ATC031: Logout and Login to see if user is lending to Alternative Financing screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Alternative Financing screen is visible
    Then user clicks on Not Now on Financial Alternative screen
    Then verify that Ok got it for Not Not option is displayed

  @Sprint10
  Scenario: CUICE-9341 >> ATC032: Logout and Login to see if user is lending to Alternative Financing screen after alert
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Alternative Financing screen is visible
    Then user clicks on Not Now on Financial Alternative screen
    Then user clicks on Ok got it from Alternative Financing screen
    Then verify that Appeal your Decision screen is visible

  @Sprint10
  Scenario: CUICE-9341 >> ATC033: Logout and Login to see if user is lending to Appeal your Decision screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Appeal your Decision screen is visible
    Then user clicks on Ok got it on Appleal your Decision screen

  @Sprint10
  Scenario: CUICE-9341 >> ATC033: Logout and Login to see if user is lending to Appeal your Decision screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Re-apply Overdraft screen is displayed

@SnRPartialOfferToAppealYourDecision @Regression
Feature: Verify that save and return functionality is working for Final Offer to Appeal your Decision flow

  Background: This is to add category to below scenarios
    Given that category "SnRPartialOfferToAppealYourDecision" is added for below scenarios

  @Sprint10
  Scenario: CUICE-9341 >> Prerequisite: Test if user able to view  the Final Offer screen
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user selects option 1 from Purpose of Borrowing question screen
    And user clicks on continue button on the screen
    And user selects option 3 on Residential Status screen
    And user clicks on continue button on the screen
    And user selects option 3 on Marital Status screen
    And user clicks on continue button on the screen
    And user enters minimum value "3500" in Gross Income input box
    And user clicks on continue button on the screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Yes button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Accept button on Terms and Conditions screen
    Then verify that the Partial Offer screen is displayed

  @Sprint10
  Scenario: CUICE-9341 >> ATC008: Logout and Login to see if user is lending to Partial Offer screen
    Given user exit the iceberg application and relaunch
    When user clicks on the More and then Lending button
    Then verify that the Partial Offer screen is displaye
    When user clicks on see my options button on the screen
    Then verify that Partial Offer Options screen is displayed

  @Sprint10
  Scenario: CUICE-9341 >> ATC009: Logout and Login to see if user is lending to Partial Offer Options screen
    Given user exit the iceberg application and relaunch
    When user clicks on the More and then Lending button
    Then verify that Partial Offer Options screen is displayed
    When user clicks on Decline Offer CTA on the screen
    Then verify that User Decline screen is displayed
    
    @Sprint10
  Scenario: CUICE-9341 >> ATC010: Logout and Login to see if user is lending to Customer Decline screen
    Given user exit the iceberg application and relaunch
    When user clicks on the More and then Lending button
    Then verify that User Decline screen is displayed
    Then user clicks on Next button on User decline screen
    Then verify that Alternative Financing screen is visible
    
    @Sprint10
  Scenario: CUICE-9341 >> ATC011: Logout and Login to see if user is lending to Alternative Financing screen
    Given user exit the iceberg application and relaunch
    When user clicks on the More and then Lending button
    Then verify that Alternative Financing screen is visible
    Then user clicks on Not Now on Financial Alternative screen
    Then verify that Ok got it for Not Now option is displayed
    
    @Sprint10
  Scenario: CUICE-9341 >> ATC012: Logout and Login to see if user is lending to Alternative Financing screen after alert
    Given user exit the iceberg application and relaunch
    When user clicks on the More and then Lending button
    Then verify that Alternative Financing screen is visible
    Then user clicks on I Consent on Financial Alternative screen
    Then user clicks on Ok got it for I Consent option on AF
    Then verify that Appeal your Decision screen is visible
    
    @Sprint10
  Scenario: CUICE-9341 >> ATC013: Logout and Login to see if user is lending to Appeal your Decision screen
    Given user exit the iceberg application and relaunch
    When user clicks on the More and then Lending button
    Then verify that Appeal your Decision screen is visible
    Then user clicks on Ok got it on Appleal your Decision screen
    

@SnRFullOfferToAppealYourDecision @Regression
Feature: Verify that save and return functionality is working for Suitable Offer to Appeal your Decision flow

  Background: This is to add category to below scenarios
    Given that category "SnRFullOfferToAppealYourDecision" is added for below scenarios

  @Sprint10
  Scenario: CUICE-9341 >> Prerequisite: Test if user able to view  the Final Offer screen
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
    And user clicks on No button on lending question screen
    And user clicks on Accept button on Terms and Conditions screen
    Then verify that the Final Offer screen is displayed

  @Sprint10
  Scenario: CUICE-9341 >> ATC001: Logout and Login to see if user is lending to Final Offer screen
    Given user exit the iceberg application and relaunch
    When user clicks on the More and then Lending button
    Then verify that the Final Offer screen is displayed
    Then user clicks on Continue with overdraft button on Final Offer
    Then verify that products Terms and Conditions screen is visible

  @Sprint10
  Scenario: CUICE-9341 >> ATC002: Logout and Login to see if user is lending to Product T&C screen
    Given user exit the iceberg application and relaunch
    When user clicks on the More and then Lending button
    Then verify that products Terms and Conditions screen is visible
    Then user clicks on Not Now button on products Terms and Conditions screen
    Then verify that Remind me Later screen is visible

  @Sprint10
  Scenario: CUICE-9341 >> ATC003: Logout and Login to see if user is lending to Remind me later
    Given user exit the iceberg application and relaunch
    When user clicks on the More and then Lending button
    Then verify that Remind me Later screen is visible
    Then user clicks on No, decline the offer button on screen
    Then verify that Decline Offer screen is visible

  @Sprint10
  Scenario: CUICE-9341 >> ATC004: Logout and Login to see if user is lending to Remind me later after decline screen
    Given user exit the iceberg application and relaunch
    When user clicks on the More and then Lending button
    Then verify that Remind me Later screen is visible
    Then user clicks on No, decline the offer button on screen
    Then verify that Decline Offer screen is visible
    Then user clicks on Yes button on Decline Offer screen
    Then verify that User Decline screen is displayed
    
    @Sprint10
  Scenario: CUICE-9341 >> ATC005: Logout and Login to see if user is lending to Customer Decline screen
    Given user exit the iceberg application and relaunch
    When user clicks on the More and then Lending button
    Then verify that User Decline screen is displayed
    Then user clicks on Next button on User decline screen
    Then verify that Alternative Financing screen is visible
    
    @Sprint10
  Scenario: CUICE-9341 >> ATC006: Logout and Login to see if user is lending to Alternative Financing screen
    Given user exit the iceberg application and relaunch
    When user clicks on the More and then Lending button
    Then verify that Alternative Financing screen is visible
    Then user clicks on I Consent on Financial Alternative screen
    Then verify that Ok got it for I Consent option is displayed
    
    @Sprint10
  Scenario: CUICE-9341 >> ATC006: Logout and Login to see if user is lending to Alternative Financing screen after alert
    Given user exit the iceberg application and relaunch
    When user clicks on the More and then Lending button
    Then verify that Alternative Financing screen is visible
    Then user clicks on I Consent on Financial Alternative screen
    Then user clicks on Ok got it for I Consent option on AF
    Then verify that Appeal your Decision screen is visible
    
    @Sprint10
  Scenario: CUICE-9341 >> ATC007: Logout and Login to see if user is lending to Appeal your Decision screen
    Given user exit the iceberg application and relaunch
    When user clicks on the More and then Lending button
    Then verify that Appeal your Decision screen is visible
    Then user clicks on Ok got it on Appleal your Decision screen
    

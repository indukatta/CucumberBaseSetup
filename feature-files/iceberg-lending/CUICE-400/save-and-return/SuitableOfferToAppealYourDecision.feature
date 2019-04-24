@SuitableOfferToAppealYourDecision @SaveAndReturnPostTnC @Regression
Feature: Verify that save and return functionality is working for Final Offer to Appeal your Decision flow

  Background: This is to add category to below scenarios
    Given that category "SuitableOfferToAppealYourDecision" is added for below scenarios

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
    Then verify that the Suitable Offer screen is displayed

  @Sprint10
  Scenario: CUICE-9341 >> ATC018: Logout and Login to see if user is lending to Suitable Offer screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that the Suitable Offer screen is displayed
    Then user clicks on continue button on Suitable Offer screen
    Then verify that Tailor Offer screen is visible

  @Sprint10
  Scenario: CUICE-9341 >> ATC019: Logout and Login to see if user is lending to Tailor Offer screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Tailor Offer screen is visible
    When user clicks on continue button on the screen
    Then verify that Final Offer screen is displayed

  @Sprint10
  Scenario: CUICE-9341 >> ATC020: Logout and Login to see if user is lending to Final Offer screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Final Offer screen is displayed
    Then user clicks on Not Now button on Final Offer
    Then verify that Remind me Later screen is visible

  @Sprint10
  Scenario: CUICE-9341 >> ATC021: Logout and Login to see if user is lending to Remind me later
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Remind me Later screen is visible
    Then user clicks on No, decline the offer button on screen
    Then verify that Decline Offer screen is visible
    Then user clicks on Yes button on Decline Offer screen
    Then verify that Customer Decline screen is displayed

  @Sprint10
  Scenario: CUICE-9341 >> ATC022: Logout and Login to see if user is lending to Customer Decline screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Customer Decline screen is displayed
    Then user clicks on Next button on User decline screen
    Then verify that Alternative Financing screen is visible

  @Sprint10
  Scenario: CUICE-9341 >> ATC023: Logout and Login to see if user is lending to Alternative Financing screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Alternative Financing screen is visible
    Then user clicks on I Consent on Financial Alternative screen
    Then verify that Ok got it for I Consent option is displayed

  @Sprint10
  Scenario: CUICE-9341 >> ATC024: Logout and Login to see if user is lending to Alternative Financing screen after alert
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Alternative Financing screen is visible
    Then user clicks on I Consent on Financial Alternative screen
    Then user clicks on Ok got it for I Consent option on screen
    Then verify that Appeal your Decision screen is visible

  @Sprint10
  Scenario: CUICE-9341 >> ATC025: Logout and Login to see if user is lending to Appeal your Decision screen
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    Then verify that Appeal your Decision screen is visible
    Then user clicks on Ok got it on Appleal your Decision screen

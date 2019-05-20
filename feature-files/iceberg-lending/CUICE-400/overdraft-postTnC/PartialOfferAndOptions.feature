@Regression @PartialOfferAndOptions
Feature: Verify all functionalities related to Suitable Offer screen, it covers CUICE-10262

  Background: This is to add category to below scenarios
    Given that category "PartialOfferAndOptions" is added for below scenarios

  @Sprint9
  Scenario: CUICE-10262 [ATC-01] >> Prerequisite: Test if user able to view  the partial screen
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "5440" for lending question
    And user selects option 1 from Purpose of Borrowing question screen
    And user clicks on continue button on the screen
    And user selects option 3 on Residential Status screen
    And user clicks on continue button on the screen
    And user selects option 3 on Marital Status screen
    And user clicks on continue button on the screen
    And user enters minimum value "5540" in Gross Income input box
    And user clicks on continue button on the screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Yes button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Accept button on Terms and Conditions screen
    Then verify that the Partial Offer screen is displayed

  @Sprint9
  Scenario: CUICE-10262 [ATC-02] >> Test if content on Partial Offer screen are correct
    Given that user is on the Partial Offer screen
    Then verify that logo is displayed on Partial Offer screen
    Then verify that partial offer heading "Congratulations!" is displayed
    Then verify that partial offer message "You have been approved and can borrow upto £" is displayed
    Then verify that partial offer explanation "We haven't been able to approve you for the full amount you requested but you can select one of 3 options" is displayed
    Then retrieve and save offered amount from Suitable or Partial Offer screen
    Then verify that see my options text "See my options" on the screen
    Then verify that see my options button is enabled on Partial Offer screen

  @Sprint9
  Scenario: CUICE-10262 [ATC-03] >> Test if content on Partial Offer options screen are correct
    Given that user is on the Partial Offer screen
    Then user clicks on See my options button on Partial Offer screen
    Then verify that Partial Offer options screen is visible
    Then verify that refer the decision heading "Refer The Decision" is displayed on screen
    Then verify that refer the decision description "We may be able to offer you more but we will require addition information" is displayed on screen
    Then verify that contact us for referral "Contact Us For Referral" is diaplayed on the screen
    Then verify that accept overdraft heading "Accept Overdraft" is displayed on screen
    Then verify that accept overdraft description "Annual Interest Rate of 10.65%" is displayed on screen
    Then verify that proceed with overdraft "Proceed with Overdraft" is diaplayed on the screen
    Then verify that decline overdraft heading "Decline Overdraft" is displayed on screen
    Then verify that decline overdraft description "This will end your application. You will need to re-apply if you want to borrow again." is displayed on screen
    Then verify that decline offer "Decline Offer" is diaplayed on the screen

  @Sprint9
  Scenario: CUICE-10262 [ATC-04] >> Test if Add your Overdraft screen is visible
    Given that user is on the Partial Offer options screen
    Then user clicks on Acept Overdraft CTA on the screen
    Then user clicks on back button on lending question screen

  @Sprint9
  Scenario: CUICE-10262 [ATC-05] >> Test if Decline Offer screen is visible.
    Given that user is on the Partial Offer options screen
    Then user clicks on Decline Overdraft CTA on the screen
    Then verify that Decline Offer screen is visible
    Then user clicks on No button on Decline Offer screen
    Then user clicks on Decline Overdraft CTA on the screen
    Then user clicks on Yes button on Decline Offer screen
    Then verify that Iceberg Decline screen is displayed

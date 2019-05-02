@SuitableOffer @Regression
Feature: Verify all functionalities related to Suitable Offer screen, it covers CUICE-10262

  Background: This is to add category to below scenarios
    Given that category "SuitableOffer" is added for below scenarios

  @Sprint7
  Scenario: CUICE-10262 >> Prerequisite: Test if user able to view  the Suitable screen
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

  @Sprint7
  Scenario: CUICE-10262 >> Test if content on Suitable Offer screen are correct
    Given that user is on the Suitable Offer screen
    Then verify that logo is displayed on Suitable Offer screen
    Then verify that suitable offer heading "Congratulations!" is displayed
    Then verify that suitable offer message "You have been approved and can borrow upto £" is displayed
    Then retrieve and save offered amount from Suitable Offer screen
    Then verify that continue button is enabled on Suitable Offer screen

  @Sprint7
  Scenario: CUICE-10262 >> Test if content on Tailor Offer screen are correct
    Given that user is on the Suitable Offer screen
    Then user clicks on continue button on Suitable Offer screen
    Then verify that Tailor Offer screen is visible

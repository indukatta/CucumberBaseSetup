@SuitableOffer @Regression @User1
Feature: Verify all functionalities related to Suitable Offer screen, it covers CUICE-9953

  Background: This is to add category to below scenarios
    Given that category "SuitableOffer" is added for below scenarios

  @Sprint6
  Scenario: CUICE-9953 >> Prerequisite: Test if user able to view  the Suitable screen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    #And user clicks on Apply button on Product Selection
    #And user clicks on No button on lending question screen
    #And user clicks on continue button on the screen
    #When user selects option 1 from Purpose of Borrowing question screen
    #And user clicks on continue button on the screen
    #When user selects option 3 on Residential Status screen
    #And user clicks on continue button on the screen
    #When user selects option 3 on Marital Status screen
    #And user clicks on continue button on the screen
    #When user enters minimum value "3500" in Gross Income input box
    #And user clicks on continue button on the screen
    #When user clicks on No button on lending question screen
    #When user clicks on No button on lending question screen
    #When user clicks on Yes button on lending question screen
    #When user clicks on No button on lending question screen
    When user clicks on Yes button on lending question screen
    Then verify that Terms and Conditions screen is displayed
    Then user clicks on Accept button on Terms and Conditions screen
    Then verify that the Suitable Offer screen is displayed

  @Sprint6
  Scenario: CUICE-553 >> Test if content on Suitable Offer screen are correct
    Given that user is on the Suitable Offer screen
    Then verify that logo is displayed on Suitable Offer screen
    Then verify that suitable offer message "You have been approved and can borrow up to " is displayed
    Then verify that Continue button on suitable offer is pre selected

  @Sprint6
  Scenario: CUICE-553 >> Test if content on Suitable Offer screen are correct
    Given that user is on the Suitable Offer screen
    Then user clicks on continue button on the screen

@SuitableOffer @Regression @User1
Feature: Verify all functionalities related to Suitable Offer screen, it covers CUICE-9953

  Background: This is to add category to below scenarios
    Given that category "SuitableOffer" is added for below scenarios

  @Sprint6
  Scenario: CUICE-9953 >> Prerequisite: Test if user able to view  the Suitable screen
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
    When user enters minimum value "3500" in Gross Income input box
    And user clicks on continue button on the screen
    When user clicks on No button on lending question screen
    When user clicks on No button on lending question screen
    When user clicks on Yes button on lending question screen
    When user clicks on No button on lending question screen
    When user clicks on No button on lending question screen
    Then verify that Terms and Conditions screen is displayed
    Then user clicks on Accept button on Terms and Conditions screen
    Then verify that the Suitable Offer screen is displayed

  @Sprint6
  Scenario: CUICE-553 >> Test if content on Suitable Offer screen are correct
    Given that user is on the Suitable Offer screen
    Then verify that logo is displayed on Suitable Offer screen
    Then verify that suitable offer heading "Congratulations!" is displayed
    Then verify that suitable offer message "You have been approved and can borrow upto £" is displayed
    Then retrieve and save offered amount from Suitable Offer screen
    Then verify that continue button is enabled

  @Sprint6
  Scenario: CUICE-553 >> Test if content on Tailor Offer screen are correct
    Given that user is on the Suitable Offer screen
    Then user clicks on continue button on the screen
    Then verify that Tailor Offer screen is visible
    Then verify that header "Select the amount you would like to borrow" is displayed on Tailor Offer screen
    Then verify that min default value "£100" is displayed on Tailor Offer screen
    Then verify that max default value is displayed on Trailor Offer screen
    Then verify that "Daily fee £0.00 Monthly fee max £0.00 Annual Interest Rate 10.65%" is displayed in rate and feed section
    Then verify that continue button is enabled
    
@Sprint6
  Scenario: CUICE-553 >> Test if rate gets changed with amount selected on Tailor Offer screen
    Given that user is on the Tailor Offer screen
    When user selects the suitable offer amount on Tailor Offer screen
    When user clicks on continue button on the screen
    Then verify that opted suitable offer amount is displayed on Final Offer screen
    Then verify that correct rate has been calculated on Final Offer screen
    Then user clicks on back button on lending question screen
    Given that user is on the Tailor Offer screen
    
    
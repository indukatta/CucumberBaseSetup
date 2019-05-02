@TailorOffer @Regression
Feature: Verify all functionalities related to Suitable Offer screen, it covers CUICE-10262

  Background: This is to add category to below scenarios
    Given that category "TailorOffer" is added for below scenarios

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
    Then retrieve and save offered amount from Suitable Offer screen
    Then user clicks on continue button on Suitable Offer screen
    Then verify that Tailor Offer screen is visible

  @Sprint7
  Scenario: CUICE-10262 >> Test if content on Tailor Offer screen are correct
    Given that user is on the Suitable Offer screen
    Then user clicks on continue button on Suitable Offer screen
    Then verify that Tailor Offer screen is visible
    Then verify that header "Select the amount you would like to borrow" is displayed on Tailor Offer screen
    Then verify that min default value "£100" is displayed on Tailor Offer screen
    Then verify that max "Max £" suitable amount is displayed on Trailor Offer screen
    Then verify that daily, monthly and AIR fee and rate are displayed correctly
      #| Daily fee £0.00             |
      #| Monthly fee max £0.00       |
      | Annual Interest Rate (variable) 10.65% |
    Then verify that continue button is enabled

  @Sprint10
  Scenario: CUICE-13965: Test if AIR screen appears when user clicks on i icon
    Given that user is on the Tailor Offer screen
    Then user clicks Annual Interest Rate icon on the screen
    Then verify that Annual Interest Rate screen is displayed
    Then user clicks on Close button on the AIR pop up
    Then verify that Tailor Offer screen is visible

  #Scenario Outline: CUICE-10262 >> Test if rate gets changed with amount selected on Tailor Offer screen
  #Given that user is on the Tailor Offer screen
  #And user moves slider to <SuitableAmount%> percent of maximum value on Tailor Offer screen
  #this scenarios is not part of thinslice
  #Then verify that fee has calculated correctly on Tailor Offer screen
  #Then verify that selected amount is displayed in amount text field on the screen
  #Then verify that continue button is enabled
  #
  #Examples:
  #| SuitableAmount% |
  #|              50 |
  #|              80 |
  #|             100 |
  #|               0 |
  @Sprint7
  Scenario: CUICE-12512 >> Test if selected suitable offer amount is displayed on Final Offer screen
    Given that user is on the Tailor Offer screen
    When user moves slider to 80 percent of maximum value on Tailor Offer screen
    Then user clicks on continue button on the screen
    Then verify that Final Offer screen is displayed
    Then verify that selected suitable offer amount is displayed on Final Offer screen

  @Sprint7
  Scenario: CUICE-12512 >> Test if products Terms and Conditions screen is visible
    Given that user is on Final Offer screen
    When user clicks on Continue with overdraft button on Final Offer
    Then verify that products Terms and Conditions screen is visible
    When user clicks on back button on lending question screen

  @Sprint7
  Scenario: CUICE-12512 >> Test if Remind me Later screen is visible
    Given that user is on Final Offer screen
    When user clicks on Not Now button on Final Offer
    Then verify that Remind me Later screen is visible
    Then user clicks on back button on lending question screen

  @Sprint7
  Scenario: CUICE-12512 >> Test if Tailor Offer screen is visible
    Given that user is on Final Offer screen
    When user clicks on back button on lending question screen
    Then verify that Tailor Offer screen is visible

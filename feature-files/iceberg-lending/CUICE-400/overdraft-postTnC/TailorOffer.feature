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
    Then user clicks on continue button on Suitable Offer screen
    Then verify that Tailor Offer screen is visible

  @Sprint10
  Scenario: CUICE-8891 >> Test if content on Tailor Offer screen are correct after tap on input box
    Given that user is on the Tailor Offer screen
    Then user clicks on input box to bring the keyboard up for precise input
    And verify that hint text "Please enter a value from £100 to £" is displayed on Tailor Offer screen
    And verify that Done button is enabled on the screen

  @Sprint10
  Scenario: CUICE-13956 >> Test if precise value is being round down to multiple of 10
    Given that user is on precise input box screen
    When user enter "109" in precise input box on the screen
    Then verify that Done button is enabled on the screen
    Then user clicks on Done button on Input keypad screen
    Then verify that updated amount "£100" is displayed on the screen
    And user clicks on input box to bring the keyboard up for precise input
    When user enter "101" in precise input box on the screen
    Then verify that Done button is enabled on the screen
    Then user clicks on Done button on Input keypad screen
    Then verify that updated amount "£100" is displayed on the screen

  @Sprint10
  Scenario: CUICE-8891 >> Test if Done button gets disabled when user enter less than 100
    Given that user is on the Tailor Offer screen
    When user enter "90" in precise input box on the screen
    Then verify that Done button is disabled on the screen
    Then user clicks on cancel button on the screen

  #this scenarios is not part of thinslice
  #Scenario Outline: CUICE-10262 >> Test if rate gets changed with amount selected on Tailor Offer screen
  #Given that user is on the Tailor Offer screen
  #And user moves slider to <SuitableAmount%> percent of maximum value on Tailor Offer screen
  #Then verify that fee has calculated correctly on Tailor Offer screen
  #Then verify that continue button is enabled
  #
  #Examples:
  #| SuitableAmount% |
  #|              50 |
  #|              80 |
  #|             100 |
  #|               0 |
  @Sprint7
  Scenario: CUICE-10262 >> Test if rate gets changed with amount selected on Tailor Offer screen
    Given that user is on the Tailor Offer screen
    When user moves slider to 80 percent of maximum value on Tailor Offer screen
    When user clicks on continue button on the screen
    Then verify that selected suitable offer amount is displayed on Final Offer screen
    #Below step is not part of thinslice
    #Then verify that correct rate has been calculated on Final Offer screen
    Then user clicks on back button on lending question screen
    Then verify that Tailor Offer screen is visible

  @Sprint10
  Scenario: CUICE-13965: Test if AIR screen appears when user clicks on i icon
    Given that user is on the Tailor Offer screen
    Then user clicks Annual Interest Rate icon on the screen
    Then verify that Annual Interest Rate screen is displayed
    Then user clicks on Close button on the AIR pop up
    Then verify that Tailor Offer screen is visible

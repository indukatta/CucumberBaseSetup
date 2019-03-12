@PreciseInputbox @Regression
Feature: Verify all functionalities related to Tailor Offer screen, it covers CUICE-9953

  Background: This is to add category to below scenarios
    Given that category "PreciseInputbox" is added for below scenarios

  @Sprint7
  Scenario: CUICE-9953 >> Prerequisite: Test if user able to view  the Tailor Offer screen
    Given that user is on the Credit Management screen
    Then close existing open application for the next scenario
    When user clicks on the Credit & Lending link
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
    Then retrieve and save offered amount from Suitable Offer screen
    And user clicks on continue button on the screen
    And user tap on input box to bring the keyboard up for precise input
    Then verify that precise input box appears on the screen

  @Sprint7
  Scenario: CUICE-553 >> Test if content on Tailor Offer screen are correct after tap on input box
  	Given that user is on precise input screen
    Then verify that cancel button is displayed on top corner on the screen
    And verify that min value "£100" is displayed in input box
    And verify that hint text "Please enter a value from £100 to £" is displayed on Tailor Offer screen
    And verify that Done button is enabled on the screen

  @Sprint7
  Scenario: CUICE-553 >> Test if Done button gets disabled when user enter less than 100
    Given that user is on precise input screen
    When user enter "90" in precise input box on the screen
    Then verify that Done button is disabled on the screen

  @Sprint7
  Scenario: CUICE-553 >> Test if Done button gets disabled when user enter greater than allowed
    Given that user is on precise input screen
    When user enter greater than allowed value in precise input box on the screen
    Then verify that Done button is disabled on the screen

  @Sprint7
  Scenario: CUICE-553 >> Test if entered value is not appearing on tailor offer screen when user clicks on cancel
    Given that user is on precise input screen
    Then user clicks on cancel button on the screen
    Then verify that entered values does not displayed in input box
    When user enter valid allowed value in precise input box on the screen
    Then user clicks on cancel button on the screen
    Then verify that Done button is enabled on the screen
    Then verify that entered values does not displayed in input box

  @Sprint7
  Scenario: CUICE-553 >> Test if slider value appears on precise input box as default value
    Given that user is on the Tailor Offer screen
    Then user moves slider to 40 percent of maximum value on Tailor Offer screen
    Then user tap on input box to bring the keyboard up for precise input
    Then verify that slider value is apparing in the precise input box
    Then verify that Done button is enabled on the screen

  @Sprint7
  Scenario: CUICE-553 >> Test if precise input box value gets appeared on the Tailor Offer screen
    Given that user is on precise input screen
    When user enter valid allowed value in precise input box on the screen
    Then user clicks on Done button on the screen
    Then verify that precise input box appears on the screen
    Then verify that fee has calculated correctly on Tailor Offer screen

  @Sprint7
  Scenario: CUICE-553 >> Test if precise input box value gets appeared on the Final Offer screen
    Given that user is on the Tailor Offer screen
    When user clicks on continue button on the screen
    Then verify that selected suitable offer amount is displayed on Final Offer screen
    Then verify that correct rate has been calculated on Final Offer screen
    Then user clicks on back button on lending question screen
    Given that user is on the Tailor Offer screen

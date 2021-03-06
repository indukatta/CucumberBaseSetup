@ManageOverdraftPreciseEntry @Regression
Feature: Verify all functionalities related to Magage Overdraft precise entry screen, it covers CUICE-12227

  Background: This is to add category to below scenarios
    Given that category "ManageOverdraftPreciseEntry" is added for below scenarios

  @Sprint9
  Scenario: CUICE-12227 >> Prerequisite: Test if user able to view  the Terms and Conditions screen
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
    And user clicks on Continue with overdraft button on Final Offer
    And user clicks on Accept button on Terms and Conditions screen
    And user clicks on More and then Manage Overdraft button
    Then verify that Manage Overdraft Limit screen is displayed

  @Sprint9
  Scenario: CUICE-12227 >> Test if content on Manage Overdraft screen are correct after tap on input box
  	Given that user is on precise input box screen
    Then verify that cancel button is displayed on top corner on the screen
    And verify that existing overdraft limit is displayed on the screen
    And verify that hint text "Please enter a value from ??100 to ??10,000 using multiple of 10" is displayed on the screen
    And verify that Done button is enabled on the screen

  @Sprint9
  Scenario: CUICE-12227 >> Test if precise value is being round down to multiple of 10
    Given that user is on precise input box screen
    When user enter "109" in precise input box on the screen
    Then verify that Done button is enabled on the screen
    Then user clicks on Done button on Input keypad screen
    Then verify that updated amount "??100" is displayed on the screen
    And user clicks on input box to bring the keyboard up for precise input
    When user enter "101" in precise input box on the screen
    Then verify that Done button is enabled on the screen
    Then user clicks on Done button on Input keypad screen
    Then verify that updated amount "??100" is displayed on the screen
    
  @Sprint9
  Scenario: CUICE-12227 >> Test if Done button gets disabled when user enter greater than allowed
    Given that user is on precise input box screen
    When user enter "100001" in precise input box on the screen
    Then verify that Done button is disabled on the screen

  @Sprint9
  Scenario: CUICE-12227 >> Test if Done button gets disabled when user enter less than 100
    Given that user is on precise input box screen
    When user enter "90" in precise input box on the screen
    Then verify that Done button is disabled on the screen

  @Sprint9
  Scenario: CUICE-12227 >> Test if entered value is not appearing on Manage Overdraft screen when user clicks on cancel
    Given that user is on precise input box screen
    Then user clicks on cancel button on the screen
    Then verify that entered values does not displayed in input box
    Then user clicks on input box to bring the keyboard up for precise input
    When user enter valid value in precise input box on the screen
    Then verify that Done button is enabled on the screen
    Then user clicks on cancel button on the screen
    Then verify that entered values does not displayed in input box

  @Sprint9
  Scenario: CUICE-12227 >> Test if slider value appears on precise input box as default value
    Given that user is on Manage Overdraft Limit screen
    Then user moves slider to 40 percent of maximum value on the screen
    Then user clicks on input box to bring the keyboard up for precise input
    Then verify that slider value is apparing in the precise input box
    Then verify that Done button is enabled on the screen

  @Sprint9
  Scenario: CUICE-12227 >> Test if precise input box value gets appeared on the Manage Overdraft screen
    Given that user is on precise input box screen
    When user enter valid value in precise input box on the screen
    Then user clicks on Done button on the screen
    Then verify that precise input box appears on the screen
    #This is not part of thinslice
    #Then verify that fee has calculated correctly on Tailor Offer screen


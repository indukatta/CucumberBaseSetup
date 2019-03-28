@ManageOverdraftLimit @Regression
Feature: Verify all functionalities related to Suitable Offer screen, it covers CUICE-12222

  Background: This is to add category to below scenarios
    Given that category "ManageOverdraftLimit" is added for below scenarios

  @Sprint7
  Scenario: CUICE-9953 >> Prerequisite: Test if user able to view  the Terms and Conditions screen
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
    And user clicks on I Consent on product Terms and Conditions screen
    And user clicks on More and then Manage Overdraft button
    Then verify that Manage Overdraft screen is displayed

  @Sprint10
  Scenario: CUICE-8891 >> Test if content on Tailor Offer screen are correct after tap on input box
    Then verify that Manage Overdraft screen is displayed
    Then user clicks on input box to bring the keyboard up for precise input
    And verify that hint text "Please enter a value from £100 to £" is displayed on Tailor Offer screen
    And verify that Done button is enabled on the screen

  @Sprint10
  Scenario: CUICE-13956 >> Test if precise value is being round down to multiple of 10
    Given that user is on precise input box screen
    When user enter "109" in precise input box on the screen
    Then verify that Done button is disabled on the screen
    Then verify that updated amount "100" is displayed on the screen
    And user clicks on input box to bring the keyboard up for precise input
    When user enter "101" in precise input box on the screen
    Then verify that Done button is disabled on the screen
    Then verify that updated amount "100" is displayed on the screen

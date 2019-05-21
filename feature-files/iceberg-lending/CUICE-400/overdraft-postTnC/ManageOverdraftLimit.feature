@ManageOverdraftLimit @Regression @Sprint9
Feature: Verify all functionalities related to Magage Overdraft screen, it covers CUICE-12222

  Background: This is to add category to below scenarios
    Given that category "ManageOverdraftLimit" is added for below scenarios

  @Sprint9
  Scenario: CUICE-12222 >> Prerequisite: Test if user able to view  the Terms and Conditions screen
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
    Then verify that Manage Overdraft screen is displayed

  @Sprint9
  Scenario: CUICE-12222 >> Test if content on Manage Overdraft Limit screen are correct
    Given that user is on Manage Overdraft Limit screen
    Then verify that screen title "Manage Overdraft Limit" is displayed on the screen
    Then verify that existing overdraft limit is displayed on the screen
    Then verify that max "Max £10,000" value is displayed on the screen
    Then verify that AIR component "Annual Interest Rate (variable)" is displayed on the screen
    Then verify that AIR value "10.65%" is displayed on the screen
    Then verify that change limit "Change Limit" button is disabled
    Then verify that remove overdraft "Remove Overdraft" button is disabled

  @Sprint9
  Scenario: CUICE-12222 >> Test if buttons on Manage Overdraft Limit screen are enabled/disabled
    Given that user is on Manage Overdraft Limit screen
    Then user clicks Annual Interest Rate icon on the screen
    Then verify that Annual Interest Rate screen is displayed
    Then user clicks on Close button on the AIR pop up
    Then verify that Manage Overdraft screen is displayed

  @Sprint9
  Scenario: CUICE-12222 >> Test if slider is working fine on Manage Overdraft Limit screen
    Given that user is on Manage Overdraft Limit screen
    Then user moves slider to 100 percent of maximum value on the screen
    Then verify that slider amount "10,000" is appearing on input box component
    Then user moves slider to 0 percent of maximum value on the screen
    Then verify that slider amount "100" is appearing on input box component
    
      @Sprint9
  Scenario: CUICE-12222 >> Test if Change Limit button is disabled when user move to default value
    Given that user is on Manage Overdraft Limit screen
    Then user clicks on input box to bring the keyboard up for precise input
    Then user enters existing overdraft limit in precise entry screen
    Then user clicks on Done button on Input keypad screen
    Then verify that change limit button is disabled on the screen

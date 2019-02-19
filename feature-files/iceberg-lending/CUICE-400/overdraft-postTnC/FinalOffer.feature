@FinalOffer @Regression @User1
Feature: Verify all functionalities related to Final Offer screen, it covers CUICE-9953

  Background: This is to add category to below scenarios
    Given that category "FinalOffer" is added for below scenarios

  Scenario: CUICE-9953 >> Prerequisite: Test if user able to view  the Terms and Conditions screen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    #And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "3000" for lending question
    When user selects option 1 from Purpose of Borrowing question screen
    And user clicks on continue button on the screen
    When user selects option 3 on Residential Status screen
    And user clicks on continue button on the screen
    When user selects option 3 on Marital Status screen
    And user clicks on continue button on the screen
    #When user enters minimum value "6000" in Gross Income input box
    #And user clicks on continue button on the screen
    When user clicks on No button on lending question screen
    When user clicks on No button on lending question screen
    When user clicks on Yes button on lending question screen
    When user clicks on No button on lending question screen
    When user clicks on Yes button on lending question screen
    Then verify that Terms and Conditions screen is displayed
    Then user clicks on Accept button on Terms and Conditions screen
    Then verify that the Final Offer screen is displayed
    
  Scenario: CUICE-553 >> Test if content on Final Offer screen are correct
    Given that user is on the Final Offer screen
    Then verify that logo is displayed on Final Offer screen
    Then verify that final offer heading "Add your overdraft" is displayed
    Then verify that offered overdraft amount "30000" is displayed
    Then verify that daily and monthly fee "Daily fee of £0.06 (£1.86 monthly)" is displayed
    Then verify that annual interest rate "10.6" is displayed
    
  Scenario: CUICE-553 >> Test if content on Final Offer screen are correct
    Given that user is on the Final Offer screen
    Then verify that Continue with overdraft button is pre selected
    Then verify that Not Now button is not pre selected
    
  Scenario: CUICE-553 >> Test if content on Final Offer screen are correct
    Given that user is on the Final Offer screen
    Then user clicks on Not Now button on Final Offer
    Then verify that Remind me Later screen is visible
    Then user clicks on back button on lending question screen
    
  Scenario: CUICE-553 >> Test if content on Final Offer screen are correct
    Given that user is on the Final Offer screen
    Then user clicks on Continue with overdraft button on Final Offer
    #Then verify that Overdraft TnC is visible
    #Then user clicks on back button on lending question screen

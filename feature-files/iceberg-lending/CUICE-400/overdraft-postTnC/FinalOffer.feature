@FinalOffer @Regression @User1
Feature: Verify all functionalities related to Final Offer screen, it covers CUICE-9953

  Background: This is to add category to below scenarios
    Given that category "FinalOffer" is added for below scenarios

  @Sprint6
  Scenario: CUICE-9953 >> Prerequisite: Test if user able to view  the Terms and Conditions screen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    And user clicks on Apply button on Product Selection
    And user clicks on Yes button on lending question screen
    And user call rest end point "answers" to set Amount of Borrowing "6000" for lending question
    Then user clicks on the Credit & Lending link
    When user selects option 1 from Purpose of Borrowing question screen
    And user clicks on continue button on the screen
    When user selects option 3 on Residential Status screen
    And user clicks on continue button on the screen
    When user selects option 3 on Marital Status screen
    And user clicks on continue button on the screen
    When user enters minimum value "6000" in Gross Income input box
    And user clicks on continue button on the screen
    When user clicks on No button on lending question screen
    When user clicks on No button on lending question screen
    When user clicks on Yes button on lending question screen
    When user clicks on No button on lending question screen
    When user clicks on Yes button on lending question screen
    Then verify that Terms and Conditions screen is displayed
    Then user clicks on Accept button on Terms and Conditions screen
    Then wait for Processing your Application screen to disappear
    Then verify that the Final Offer screen is displayed
    
  @Sprint6
  Scenario: CUICE-553 >> Test if content on Final Offer screen are correct
    Given that user is on the Final Offer screen
    Then verify that logo is displayed on Final Offer screen
    Then verify that final offer summary "Add your overdraft" is displayed
    Then verify that offered overdraft amount is displayed
    Then verify that daily and monthly fee "" is displayed
    Then verify that annual rate "" is displayed
    
  @Sprint6
  Scenario: CUICE-553 >> Test if content on Final Offer screen are correct
    Given that user is on the Final Offer screen
    Then verify that Continue with overdraft button is pre selected
    Then verify that Not Now button is not pre selected
    
    @Sprint6
  Scenario: CUICE-553 >> Test if content on Final Offer screen are correct
    Given that user is on the Final Offer screen
    Then user clicks on Not Now button on Final Offer
    Then verify that Remind me Later screen is visible
    Then user clicks on back button on lending question screen
    
    @Sprint6
  Scenario: CUICE-553 >> Test if content on Final Offer screen are correct
    Given that user is on the Final Offer screen
    Then user clicks on Continue with overdraft button on Final Offer
    #Then verify that Overdraft TnC is visible
    #Then user clicks on back button on lending question screen

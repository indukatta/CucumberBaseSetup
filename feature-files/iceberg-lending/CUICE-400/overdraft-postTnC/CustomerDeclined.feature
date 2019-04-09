@CustomerDeclined @Regression
Feature: Verify all functionalities related to Decline Offer screen, it covers CUICE-9953, CUICE-13956

  Background: This is to add category to below scenarios
    Given that category "CustomerDeclined" is added for below scenarios

  @Sprint7 @Sprint10
  Scenario: CUICE-13956 >> Prerequisite: Test if user able to view  the Decline Offer screen
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
    And user enters minimum value "1000" in Gross Income input box
    And user clicks on continue button on the screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Yes button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Accept button on Terms and Conditions screen
    And verify that the Final Offer screen is displayed
    And user clicks on Not Now button on Final Offer
    And user clicks on No, decline the offer button on screen
    And user clicks on Yes button on Decline Offer screen
    Then verify that Customer Decline screen is displayed
    
  @Sprint7 @Sprint10
  Scenario: CUICE-13956 >> Test if content on User Decline screen are correct
    Given that user is on Customer Decline screen
    Then verify that title "Sorry we didn’t meet your needs" on User Decline screen is displayed
    Then verify that decline options "Here’s what you can do now:" is displayed
    Then verify that consider alternative text "•	We can refer you for alternative financing options under the government’s Designated Online Finance Platforms" is displayed
    Then verify that appeal decision text "•	Appeal this decision" is displayed
    Then verify that Next button is displayed on User Decline screen
    
  @Sprint7 @Sprint10
  Scenario: CUICE-13956 >> Test if content on User Decline screen are correct
    Given that user is on Customer Decline screen
    Then user clicks on Next button on User decline screen
    Then verify that Alternative Financing screen is visible
    Then user clicks on back button on lending question screen
    Then verify that Customer Decline screen is displayed
    
    
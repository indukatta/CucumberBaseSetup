@IcebergDeclined @Regression
Feature: Verify all functionalities related to Decline Offer screen, it covers CUICE-9953

  Background: This is to add category to below scenarios
    Given that category "IcebergDeclined" is added for below scenarios

  @Sprint7 @Sprint10
  Scenario: CUICE-9953 >> Prerequisite: Test if user able to view  the Decline Offer screen
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "8800" for lending question
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
    Then verify that Iceberg Decline screen is displayed

  @Sprint7 @Sprint10
  Scenario: CUICE-553 >> Test if content on User Decline screen are correct
    Given that user is on Iceberg Decline screen
    Then verify that first line of description "We made this decision based on information held by us and from the Credit reference agency Experian." is displayed on screen
    Then verify that second line of description "You can get a copy of your credit record here:" is displayed on screen
    Then verify that Experian info "Contact Experian at uk.experian.com" is displayed on screen
    Then verify that decline options "Here’s what you can do now:" on Iceberg declined screen
    Then verify that consider alternative text "•	We can refer you for alternative financing options under the government’s Designated Online Finance Platforms" on Iceberg declined screen
    Then verify that appeal decision text "•	Appeal this decision" on Iceberg declined screen
    Then verify that Next button is displayed on Iceberg Decline screen

  @Sprint7 @Sprint10
  Scenario: CUICE-553 >> Test if content on User Decline screen are correct
    Given that user is on Iceberg Decline screen
    Then user clicks on Next button on Iceberg decline screen
    Then verify that Alternative Financing screen is visible
    Then user clicks on back button on lending question screen
    Then verify that Customer Decline screen is displayed

@AppealYourDecision @Regression
Feature: Verify all functionalities related to Decline Offer screen, it covers CUICE-11090

  Background: This is to add category to below scenarios
    Given that category "AppealYourDecision" is added for below scenarios

  @Sprint8
  Scenario: CUICE-11090 >> Prerequisite: Test if user able to view  the Alternative Financing screen
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
    And user clicks on Next button on Iceberg decline screen
    Then verify that Alternative Financing screen is visible

  @Sprint8
  Scenario: CUICE-11177 >> Test if user is able to see and verify Ok got it screen after clicking on I consent
    Given that user is on Alternative financing screen
    And user clicks on I Consent on Financial Alternative screen
    Then verify that alert image is displayed on the screen
    Then verify that alert title "Thanks!" is displayed on the screen
    Then verify that alert body "We'll send your details to the Designated Online Finance Platforms. We will now show you how you can appeal." is displayed on the screen
    Then verify that alert button Ok got it is displayed on the screen
    Then user clicks on Ok got it button on alert screen
    Then verify that Appeal your Decision screen is visible

  @Sprint8
  Scenario: CUICE-11177 >> Test if user is able to see and verify Ok got it screen after clicking on I consent
    Given that user is on Appeal your decision screen
    Then verify that the heading label "Appeal your decision" is displayed on screen
    Then verify that the correnct reference number is displayed on the screen
    Then verify that the web view component is displayed on the screen
    Then verify that the Ok got it button is enabled on the screen

  @Sprint8
  Scenario: CUICE-11090 >> Test if user is able to test first find out more on Appeal your decision screen
    Given that user is on Appeal your decision screen
    Then user clicks on first find out more link on Appeal your decision screen
    Then verify that web view with done button is opened on the screen
    Then user clicks on done button on web view on the screen
    Then verify that Appeal your Decision screen is visible

  @Sprint8
  Scenario: CUICE-11090 >> Test if user is able to test find out more on Appeal your decision screen
    Given that user is on Appeal your decision screen
    Then user clicks on second find out more link on Appeal your decision screen
    Then verify that web view with done button is opened on the screen
    Then user clicks on done button on web view on the screen
    Then verify that Appeal your Decision screen is visible

  @Sprint8
  Scenario: CUICE-11090 >> Test if user is able to test find out more on Appeal your decision screen
    Given that user is on Appeal your decision screen
    When user clicks on Ok got it on Appleal your Decision screen
    Then verify that homescreen is visible on the screen

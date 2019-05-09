@Regression
Feature: Verify all functionalities related to Apply and Re Apply within and after 30 days as applicable

  Background: This is to add category to below scenarios
    Given that category "ReApplyOverdraft" is added for below scenarios
    Then close existing open application for the next scenario

  Scenario: CUICE-6397 >> Test if user able to view 'LAST SAVED Q&A' for No PSE decision -> logic on datemodified -> within 30 days
    Given that user is on the Iceberg Homescreen
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
    And user enters minimum value "6000" in Gross Income input box
    And user clicks on continue button on the screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Yes button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    Then verify that Terms and Conditions screen is displayed
    Then decrease application datemodified column by 15 days in application table
    Given that user is on the Iceberg Homescreen
    And user clicks on the More and then Lending button
    Then verify that SustainabilityCheck screen is displayed
    Then close existing open application for the next scenario

  Scenario: CUICE-6397 >> Test if user able to view 'Re Apply' on product selection for PSE decision->declined->within 30 days
    Given that user is on the Iceberg Homescreen
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
    And user enters minimum value "6000" in Gross Income input box
    And user clicks on continue button on the screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Yes button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Accept button on Terms and Conditions screen
    Then verify that "declined" decision is coming in PSE response
    Then decrease psedecision datetime by 28 days in application table
    Then verify that Iceberg Decline screen is displayed
    Given that user is on the Iceberg Homescreen
    And user clicks on the More and then Lending button
    Then verify that "Re Apply" button is shown on product selection screen
    Then user clicks on Apply button on Product Selection
    Then verify that Re-apply Overdraft screen is displayed
    Then verify that screen body "You recently applied for an overdraft. You can re-apply from" displayed on the screen
    Then verify that date in "re-apply from" component displays 2 days from today on the screen

  Scenario: CUICE-6397 >> Test if user able to view 'Re Apply' on product selection for PSE decision->referred->within 30 days
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "5800" for lending question
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
    Then verify that Iceberg Decline screen is displayed
    Then verify that "referred" decision is coming in PSE response
    Then decrease psedecision datetime by 25 days in application table
    Then verify that Iceberg Decline screen is displayed
    Given that user is on the Iceberg Homescreen
    And user clicks on the More and then Lending button
    Then verify that "Re Apply" button is shown on product selection screen
    Then user clicks on Apply button on Product Selection
    Then verify that Re-apply Overdraft screen is displayed
    Then verify that screen body "You recently applied for an overdraft. You can re-apply from" displayed on the screen
    Then verify that date in "re-apply from" component displays 5 days from today on the screen

  Scenario: CUICE-6397 >> Test if user able to view 'Re Apply' on product selection for PSE decision->accepted-> Sustainability Yes->within 30 days
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "4800" for lending question
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
    And user clicks on Yes button on lending question screen
    And user clicks on Accept button on Terms and Conditions screen
    Then verify that Iceberg Decline screen is displayed
    Then verify that "accepted" decision is coming in PSE response
    Then decrease psedecision datetime by 20 days in application table
    Then verify that Iceberg Decline screen is displayed
    Given that user is on the Iceberg Homescreen
    And user clicks on the More and then Lending button
    Then verify that "Re Apply" button is shown on product selection screen
    Then user clicks on Apply button on Product Selection
    Then verify that Re-apply Overdraft screen is displayed
    Then verify that screen body "You recently applied for an overdraft. You can re-apply from" displayed on the screen
    Then verify that date in "re-apply from" component displays 10 days from today on the screen

  @ReApplyOverdraft
  Scenario: CUICE-6397 >> Test if user able to view 'Re Apply' on product selection for PSE decision->declined-> Sustainability Yes->on 29 days
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "7800" for lending question
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
    And user clicks on Yes button on lending question screen
    And user clicks on Accept button on Terms and Conditions screen
    Then verify that Iceberg Decline screen is displayed
    Then verify that "declined" decision is coming in PSE response
    Then decrease psedecision datetime by 29 days in application table
    Given that user is on the Iceberg Homescreen
    And user clicks on the More and then Lending button
    Then verify that "Re Apply" button is shown on product selection screen
    Then user clicks on Apply button on Product Selection
    Then verify that Re-apply Overdraft screen is displayed
    Then verify that screen body "You recently applied for an overdraft. You can re-apply from" displayed on the screen
    Then verify that date in "re-apply from" component displays 1 days from today on the screen

  Scenario: CUICE-6397 >> Test if user able to view 'Apply' on product selection for PSE decision->referred-> Sustainability Yes-> on 30 days
    Given that user is on the Iceberg Homescreen
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "5800" for lending question
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
    And user clicks on Yes button on lending question screen
    And user clicks on Accept button on Terms and Conditions screen
    Then verify that Iceberg Decline screen is displayed
    Then verify that "referred" decision is coming in PSE response
    Then decrease psedecision datetime by 30 days in application table
    Then verify that Iceberg Decline screen is displayed
    Given that user is on the Iceberg Homescreen
    And user clicks on the More and then Lending button
    Then verify that "Apply" button is shown on product selection screen
    Then user clicks on Apply button on Product Selection
    Then verify that Amount of Borrowing YesNo screen is displayed

@ApplyOverdraft
Feature: Verify all functionalities related to Apply and Re Apply within and post 30 and 60 days as applicable

  Background: This is to add category to below scenarios
    Given that category "ApplyOverdraft" is added for below scenarios

  Scenario: CUICE-9953 >> Test if user able to view 'Apply' on product selection for No PSE decision->datemodified of application > more than 30 days
    Given that user is on the Credit Management screen
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
    And user enters minimum value "6000" in Gross Income input box
    And user clicks on continue button on the screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Yes button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    Then verify that Terms and Conditions screen is displayed
    Then decrease application datemodified column by 35 days in application table
    Given that user is on the Credit Management screen
    And user clicks on the Credit & Lending link
    Then verify that Product Selection screen is displayed

  Scenario: CUICE-9953 >> Test if user able to view 'Apply' PSE decision->accepted->No customer decision->more than 30 days
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "4500" for lending question
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
    Then verify that the Final Offer screen is displayed
    Then verify that "accepted" decision is coming in PSE response
    Then decrease psedecision datetime by 38 days in application table
    Given that user is on the Credit Management screen
    And user clicks on the Credit & Lending link
    Then verify that "Apply" button is shown on product selection screen

  Scenario: CUICE-9953 >> Test if user able to view 'Re Apply' on product selection for PSE decision->referred->More than 60 days
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
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
    Then verify that the Iceberg Decline screen is displayed
    Then verify that "referred" decision is coming in PSE response
    Then decrease psedecision datetime by 61 days in application table
    Given that user is on the Credit Management screen
    And user clicks on the Credit & Lending link
    Then verify that "Apply" button is shown on product selection screen

  Scenario: CUICE-9953 >> Test if user able to view 'Apply' on product selection for PSE decision->declined->More than 60 days
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "8500" for lending question
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
    Then verify that the Iceberg Decline screen is displayed
    Then verify that "declined" decision is coming in PSE response
    Then decrease psedecision datetime by 61 days in application table
    Given that user is on the Credit Management screen
    And user clicks on the Credit & Lending link
    Then verify that "Apply" button is shown on product selection screen

  Scenario: CUICE-9953 >> Test if user able to view 'Apply' on product selection for PSE decision->accepted-> Sustainability Yes->More than 60 days
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "4500" for lending question
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
    Then verify that the Iceberg Decline screen is displayed
    Then verify that "accepted" decision is coming in PSE response
    Then decrease psedecision datetime by 61 days in application table
    Given that user is on the Credit Management screen
    And user clicks on the Credit & Lending link
    Then verify that "Apply" button is shown on product selection screen
    
  Scenario: CUICE-9953 >> Test if user able to view 'Apply' on product selection for PSE decision->referred-> Sustainability Yes->More than 60 days
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
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
    Then verify that the Iceberg Decline screen is displayed
    Then verify that "referred" decision is coming in PSE response
    Then decrease psedecision datetime by 61 days in application table
    Given that user is on the Credit Management screen
    And user clicks on the Credit & Lending link
    Then verify that "Apply" button is shown on product selection screen

  Scenario: CUICE-9953 >> Test if user able to view 'Re Apply' on product selection for PSE decision->declined-> Sustainability Yes->More than 60 days
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
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
    Then verify that the Iceberg Decline screen is displayed
    Then verify that "declined" decision is coming in PSE response
    Then decrease psedecision datetime by 61 days in application table
    Given that user is on the Credit Management screen
    And user clicks on the Credit & Lending link
    Then verify that "Apply" button is shown on product selection screen

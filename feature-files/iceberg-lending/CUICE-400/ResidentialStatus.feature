@residentialStatus
Feature: Verify all functionalities related to Residential Status screen. It will covers following stories CUICE-6175

  Scenario: CUICE-8934 >> ATC-001: Test if user able to view  the Residential Status screen
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link

  Scenario: CUICE-8934 >> ATC-002: Test if user is able to view the Residential Status lending question and its choices
    Given user is on Residential Status lending question screen
    Then verify that Residential Status description "What is your residential status?" on screen
    And verify that below Residential Status options are displayed
      | Halls of residence   |
      | Living with a parent |
      | Owner occupier       |
      | Tenant               |
      | Others               |
    And verify that none of the options are pre selected
    And verify that continue button is disabled

  Scenario: CUICE-8934 >> ATC-003: Test if user is able to select any one of the choices on the Residential Status screen
    Given user is on Residential Status lending question screen
    When user clicks on Halls of residence option on Residential Status screen
    Then verify that continue button is enabled

  Scenario: CUICE-8934 >> ATC-004: Test if user is able to select only one of the choices on the Residential Status screen
    Given user is on Residential Status lending question screen
    When user clicks on Halls of residence option on Residential Status screen
    And user clicks on Owner occupier option on Residential Status screen
    Then verify that Halls of residence option is deselected
    And verify that continue button is enabled

  Scenario: CUICE-8934 >> ATC-005: Test if user is able to navigate to the next screen when continue button is clicked
    Given user is on Residential Status lending question screen
    When user clicks on Tenant option on Residential Status screen
    And user clicks on continue button on the screen

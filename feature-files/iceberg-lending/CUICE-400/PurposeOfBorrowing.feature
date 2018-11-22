@purposeOfBorrowing
Feature: Verify all functionalities related to Purpose of Borrowing screen, it will cover following stories

  Scenario: CUICE-6173 >> ATC-001: Test if user is able to view "Purpose of borrowing" header and "Borrowing" title
    Given that user is on Product Selection screen
    When user clicks on Apply button on Product Selection
    Then verify that screen title "Borrowing" is displayed.
    And verify that Purpose of Borrowing "Purpose of borrowing" is displayed
  
  Scenario: CUICE-6173 >> ATC-002: Test if user is able to view the "Purpose of Borrowing" - Chioces
    Given that user is on Purpose of Borrowing screen
    Then verify that following Purpose of Business questions are displayed on screen
      | Asset purchase                     |
      | Debt consolidation (HSBC)          |
      | Debt consolidation (non-HSBC)      |
      | Furniture & fittings               |
      | Motor vehicles                     |
      | Premises expansion                 |
      | Premises refurbishment             |
      | Property develpoment adn sale      |
      | Property purchase - Investment     |
      | Property purchase - own occupation |
      | Stock purchase                     |
      | Working capital                    |
      | Other                              |

  Scenario: CUICE-6173 >> ATC-003: Test if Continue button is disabled and no option is selected by default
    Given that user is on Purpose of Borrowing screen
    Then verify that continue button is disabled
    And verify that no default option is pre-selected

  Scenario: CUICE-6173 >> ATC-004: Test if Continue button is enabled if one option is selected
    Given that user is on Purpose of Borrowing screen
    When user selects an option from Purpose of Borrowing Question
    Then verify that continue button is enabled
    
  Scenario: CUICE-6173 >> ATC-005: Test if Continue button is enabled if all options are selected
    Given that user is on Purpose of Borrowing screen
    When user selects all options from Purpose of Borrowing Question
    Then verify that continue button is enabled

  Scenario: CUICE-6173 >> ATC-006: Test if user is taken to the "Residential Status" lending question when clicked on Continue button.
    Given that user is on Purpose of Borrowing screen
    When user selects an option from Purpose of Borrowing Question
    And user clicks on continue button on the screen
    Then verify that Residential Status lending question screen is displayed
  
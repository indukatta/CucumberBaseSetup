@productSelection
Feature: Verify all functionalities related to Product Selection screen, it will cover following stories CUICE-540, CUICE-542

  Scenario: CUICE-540 >> ATC-001: Test if user is able to view the product categories screen if not already taken out
    Given user is on the XX screen
    When user clicks on the Product Selection link
    Then verify product selection header as "Do you want to add an extra products or services?" on screen

  Scenario: CUICE-540 >> ATC-002: Test the content on the "Product Selection" screen
    Given user is on Product Selection screen
    Then verify product selection header as "Do you want to add an extra products or services?" on screen
    Then verify icon displayed on screen
    Then verify product name as "Business Overdrafts" on screen
    Then verify product benefit as "Best for flexible access to cash flow" on screen
    Then verify link "Find out more" on screen
    Then verify apply as "Apply" on screen
    Then verify skip as "Skip" on screen

  Scenario: CUICE-540 >> ATC-003: Test if user is taken back to "Lending Question" screen after Apply is clicked
    Given user is on Product Selection screen
    When user clicks on Apply button
    Then verify lending question screen is displayed

  Scenario: CUICE-540 >> ATC-004: Test if user is taken back to "XX" screen after Skip is clicked
    Given user is on the XX screen
    Given user is on Product Selection screen
    When user clicks on Skip button
    Then verify that XX screen is displayed
    
  Scenario: CUICE-540 >> MTC-005: Verify icon, spacing between sub components alignment of text and/or sub component and over all UI
    Given user is on Product Selection screen
    Then Verify broken link for icon image on the screen
    Then Verify product name, description and Find out more are left aligned
    Then Verify Apply and Skip buttons are center aligned
    Then Verify Apply button is auto highlighted
    Then Verify spacing between each components and/or sub screen
    Then Verify overall UI of Product Selection screen as per UX
    
  Scenario: Product Selection >> CUICE-542 >> ATC-001: Test if user is taken to "Product Details" screen after find out more is clicked
    Given user is on Product Selection screen
    When user clicks on find out more link
    Then verify product name "Business Overdraft" on Product Details screen

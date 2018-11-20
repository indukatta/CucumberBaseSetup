@productSelection
Feature: Verify all functionalities related to Product Selection screen. It will covers following stories CUICE-540, CUICE-542
  
  Scenario: CUICE-540 >> ATC-001: Test if user is able to view the product categories screen if not already taken out
    Given that user is on the Credit Management screen
    When user clicks on the Credit & Lending link
    Then verify Select Products description "Do you want to add extra products or services?" on screen
  
  Scenario: CUICE-540 >> ATC-002: Test the content on the "Select Products" screen
    Given that user is on Product Selection screen
    Then verify Select Products description "Do you want to add extra products or services?" on screen
    Then verify product icon is displayed on screen
    Then verify product name "Business Overdrafts" on Select Products screen
    Then verify product benefit "Best for flexible access to cash flow" on screen
    Then verify Find Out More link "Find Out More" on screen
    Then verify Apply button "Apply" on screen
  
  Scenario: CUICE-540 >> ATC-003: Test if user is taken back to "Lending Question" screen after Apply is clicked
    Given that user is on Product Selection screen
    When user clicks on Apply button on Product Selection
    Then verify lending question screen is displayed
  
  Scenario: CUICE-540 >> MTC-005: Verify icon, spacing between sub components alignment of text and/or sub component and over all UI
    Then verify broken link for icon image on the screen
    Then verify product name description and Find out more are left aligned
    Then verify Apply button center aligned
    Then verify Apply button is auto highlighted
    Then verify spacing between each components and/or sub screen
    Then verify overall UI of Product Selection screen as per UX
  
  Scenario: CUICE-542 >> ATC-001: Test if user is taken to "Product Details" screen after find out more is clicked
    Given that user is on Product Selection screen
    When user clicks on find out more link
    Then verify product name "Business Overdrafts" on Product Details screen
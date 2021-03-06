 @Regression
Feature: Verify all functionalities related to Product Details screen, it will cover following stories CUICE-542, CUICE-6194, CUICE-3911

  Background: This is to add category to below scenarios
    Given that category "ProductDetails" is added for below scenarios

  @Sprint2 @ProductDetails
  Scenario: CUICE-542 >> Pre-requisite: Login and open Product Details screen
    Given that user is on the Iceberg Homescreen
    #Then close existing open application for the next scenario
    #When user clicks on the More and then Lending button
    #When user clicks on find out more link
    #Then verify that Product Details screen is displayed

  @Sprint2
  Scenario: CUICE-542 >> ATC-001: Verify other static content on Product Details screen.
    Given user is on Product Details screen
    Then verify product name "Overdrafts" on Product Details screen
    Then verify product description "Best for flexible access to cash flow" on screen
    Then verify feature and benefit heading "Features and Benefits" on screen
    Then verify features and benefits on the screen
      | •	No arrangement fee                                       |
      | •	Pay interest only on the amount you use calculated daily |
      | •	Same day availability (if approved)                      |
    Then verify overdraft fee and interest given below
      | Overdraft fee 1.5% (monthly charge) |
      | Interest is 9.9% EAR Representative |
    #Then verify terms and conditions heading "Terms and Conditions" on screen

  @Sprint2
  Scenario: CUICE-542 >> MTC-003: Verify icon, spacing between sub components alignment of text and/or sub component and over all UI
    Then verify broken link for icon image on the screen
    Then verify product name and description are center aligned
    Then verify other components and sub components are left aligned
    Then verify outline for each components and/or sub screen
    Then verify spacing between each components and/or sub screen
    Then verify each section header is bold
    Then verify indentation for Features and Benefits
    Then verify overall UI of Product Details screen as per UX

  @Sprint2
  Scenario: CUICE-6194 >> ATC-001: Verify static overdraft range on Product Details screen
    Given user is on Product Details screen
    Then verify overdraft range "Overdraft between £1 - £10,000" is displayed on product details screen

  @Sprint2
  Scenario: CUICE-3914 >> ATC-001: Verify static warning message on Product Details screen
    Given user is on Product Details screen
    Then verify product purpose "Business borrowing cannot be used for personal use" is displayed on product details screen
    Then user clicks on Back button on Product Details screen

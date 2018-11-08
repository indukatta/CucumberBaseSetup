Feature: Verify all functionalities related to Product Details screen, it will cover following stories CUICE-542, CUICE-6194, CUICE-3911

  Scenario: CUICE-542|TC-001: Verify other static content on Product Detais screen.
    Given user is on Product Details screen
    Then verify product name as "Business overdraft" on screen
    Then verify product description as "Best for flexible acces to cash flow" on screen
    Then verify feature and benefit heading as "Features and Benefits" on screen
    Then verify features and benefits on the screen
      | No arrangement fee                                      |
      | Pay interes only on the amount you use calculated daily |
      | Same day availability (if approved)                      |
    Then overdraft fee and interest
      | Overdraft fee 1.5% (charged monthly) |
      | Interest is 9.9% EAR Representative |
    Then verify rate and charges heading as "Rates and charges" on screen
    Then verify terms and conditions heading as "Terms and Conditions" on screen
    Then verify terms and conditions details as "Business Overdrafts"

  Scenario: CUICE-542|TC-002: Verify terms and conditions is not clickable.
    Given user is on Product Details screen
    Then verify terms and conditions details is clickable.

  Scenario: CUICE-6194|TC-001: Verify static overdraft range on Product Details screen
    Given user is on Product Details screen
    Then verify overdraft range "Overdraft between £1 - £10,000" is displayed on product details screen

  Scenario: CUICE-3914|TC-001: Verify static warning message on Product Details screen
    Given user is on Product Details screen
    Then verify product waring "Business borrowing cannot be used for personal use" is displayed on product details screen

@Regression @ReApplyOverdraft
Feature: Verify all functionalities related to Apply and Re Apply within and after 30 days as applicable

  Background: This is to add category to below scenarios
    Given that category "ReApplyOverdraft" is added for below scenarios

  Scenario: ATC-001 >> CUICE-6397: Test if user able to view 'LAST SAVED Q&A' for No PSE decision -> logic on datemodified -> within 30 days
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
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
    Then verify that Terms and Conditions screen is displayed

  Scenario: ATC-002 >> CUICE-6397: Test if user able to view 'Re Apply' on product selection for PSE decision->declined->within 30 days
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
    And user enters minimum value "6000" in Gross Income input box
    And user clicks on continue button on the screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Yes button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on No button on lending question screen
    And user clicks on Accept button on Terms and Conditions screen
    Then verify that "declined" decision is coming in PSE response
    Then verify that Iceberg Decline screen is displayed
    Then user navigate from decline screen to homescreen without Consent on Alternative Financing
    Then decrease psedecision datetime by 28 days in application table
    Given that user is on the Iceberg Homescreen
    And user clicks on the More and then Lending button
    Then verify that "Re Apply" button is shown on product selection screen
    Then user clicks on Apply button on Product Selection
    Then verify that Re-apply Overdraft screen is displayed
    Then verify that screen body "You recently applied for an overdraft. You can re-apply from" displayed on the screen
    Then verify that date in "re-apply from" component is 2 days from today on the screen

  Scenario: ATC-003 >> CUICE-15908: Test if content and options on Re-Apply overdraft screen is correct
    Given that user is on Re-Apply overdraft screen
    Then verify that Re-apply overdraft heading "Re-applying for an Overdraft" is displayed
    Then verify that What Next lable "What you can do next..." is displayed on the screen
    Then verify that Explore options "Explore one or both options:" is displayed on the screen
    Then verify that Alternative financing "Consider alternative financing" is displayed on the screen
    Then verify that Alternative financing description "We can refer your case under Government's referral scheme to alternative providers." is displayed on the screen
    Then verify that Appeal your decision "Appeal your decision" is displayed on the screen
    Then verify that Appeal your decision description "You can appeal and have decision reassessed by our team." is displayed on the screen
    Then verify that Not now CTA is displayed on the screen

  Scenario: ATC-004 >> CUICE-15908: Test if homescreen is displayed when user clicks on Not now button on Re-Apply overdraft
    Given that user is on Re-Apply overdraft screen
    And user clicks on Not now button on the screen
    Then verify that homescreen is visible
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    Then verify that Re-apply Overdraft screen is displayed

  Scenario: ATC-005 >> CUICE-15908: Test if Alternative financing screen is displayed when user clicks on Consider Alternative Financing
    Given that user is on Re-Apply overdraft screen
    When user clicks on Consider alternative financing option on the screen
    Then verify that Alternative Financing screen is visible
    Then verify that I consent button is enabled on the Alternative financing screen
    Then verify that Not now button is enabled on the Alternative finanging  screen
    When user clicks on Not Now on Financial Alternative screen
    Then user clicks on Ok got it for I Consent or Not now options on screen

  #Then verify that Re-apply Overdraft screen is displayed
  Scenario: ATC-0006 >> CUICE-15908: Test if Appeal your decision screen is displayed when user clicks on Appeal your decision
    #Temporary solution for next test case
    And user clicks on the More and then Lending button
    Then user clicks on Apply button on Product Selection
    Given that user is on Re-Apply overdraft screen
    Then user clicks on Appeal your decision option on the screen
    Then verify that Appeal your Decision screen is visible
    Then user clicks on Ok got it on Appleal your Decision screen

  #Then verify that Re-apply Overdraft screen is displayed
  Scenario: ATC-007 >> CUICE-15908: Test if I consent button goes Gray when user clicks on I consent after Re-Apply overdraft screen
    #Temporary solution for next test case
    And user clicks on the More and then Lending button
    Then user clicks on Apply button on Product Selection
    Given that user is on Re-Apply overdraft screen
    When user clicks on Consider alternative financing option on the screen
    Then verify that Alternative Financing screen is visible
    When user clicks on I Consent on Financial Alternative screen
    Then user clicks on Ok got it for I Consent or Not now options on screen
    #Then verify that Re-apply Overdraft screen is displayed
    #Temporary solution for next test case
    And user clicks on the More and then Lending button
    Then user clicks on Apply button on Product Selection
    When user clicks on Consider alternative financing option on the screen
    Then verify that I consent button is disabled on the Alternative financing screen

  Scenario: ATC-008 >> CUICE-6397: Test if user able to view 'Re Apply' on product selection for PSE decision->referred->within 30 days
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "6800" for lending question
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
    Then user navigate from decline screen to homescreen with Consent on Alternative Financing
    Then decrease psedecision datetime by 25 days in application table
    Given that user is on the Iceberg Homescreen
    And user clicks on the More and then Lending button
    Then verify that "Re Apply" button is shown on product selection screen
    Then user clicks on Apply button on Product Selection
    Then verify that Re-apply Overdraft screen is displayed
    Then verify that screen body "You recently applied for an overdraft. You can re-apply from" displayed on the screen
    Then verify that date in "re-apply from" component is 5 days from today on the screen

  Scenario: ATC-009 >> CUICE-15908: Test if I consent goes Gray when user clicks on I consent on Alternative financing after decline screen
    Given that user is on Re-Apply overdraft screen
    When user clicks on Consider alternative financing option on the screen
    Then verify that Alternative Financing screen is visible
    Then verify that I consent button is disabled on the Alternative financing screen

  Scenario: ATC-010 >> CUICE-6397: Test if user able to view 'Re Apply' on product selection for PSE decision->accepted-> Sustainability Yes->within 30 days
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
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
    Then verify that "fullOffer" decision is coming in PSE response
    Then verify that Iceberg Decline screen is displayed
    Then user navigate from decline screen to homescreen without Consent on Alternative Financing
    Then decrease psedecision datetime by 20 days in application table
    Given that user is on the Iceberg Homescreen
    And user clicks on the More and then Lending button
    Then verify that "Re Apply" button is shown on product selection screen
    Then user clicks on Apply button on Product Selection
    Then verify that Re-apply Overdraft screen is displayed
    Then verify that screen body "You recently applied for an overdraft. You can re-apply from" displayed on the screen
    Then verify that date in "re-apply from" component is 10 days from today on the screen

  Scenario: ATC-011 >> CUICE-6397: Test if user able to view 'Re Apply' on product selection for PSE decision->declined-> Sustainability Yes->on 29 days
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
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
    Then user navigate from decline screen to homescreen without Consent on Alternative Financing
    Then decrease psedecision datetime by 29 days in application table
    Given that user is on the Iceberg Homescreen
    And user clicks on the More and then Lending button
    Then verify that "Re Apply" button is shown on product selection screen
    Then user clicks on Apply button on Product Selection
    Then verify that Re-apply Overdraft screen is displayed
    Then verify that screen body "You recently applied for an overdraft. You can re-apply from" displayed on the screen
    Then verify that date in "re-apply from" component is 1 days from today on the screen

  Scenario: ATC-012 >> CUICE-6397: Test if user able to view 'Apply' on product selection for PSE decision->referred-> Sustainability Yes-> on 30 days
    Given that user is on the Iceberg Homescreen
    Then close existing open application for the next scenario
    When user clicks on the More and then Lending button
    And user clicks on Apply button on Product Selection
    And user clicks on No button on lending question screen
    And user clicks on continue button on the screen
    And user call rest end point "answers" to set Amount of Borrowing "6800" for lending question
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
    Then user navigate from decline screen to homescreen without Consent on Alternative Financing
    Then decrease psedecision datetime by 30 days in application table
    Given that user is on the Iceberg Homescreen
    And user clicks on the More and then Lending button
    Then captures updated screenshot for execution results
    Then verify that "Add" button is shown on product selection screen
    Then user clicks on Apply button on Product Selection
    Then verify that Amount of Borrowing YesNo screen is displayed

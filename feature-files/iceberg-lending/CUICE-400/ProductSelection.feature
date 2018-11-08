@productSelection
Feature: Verify all functionalities related to Product Selection screen, it will cover following stories CUICE-540, CUICE-542

	Scenario: Product Selection >> CUICE-540 >> TC-001: Test if user is able to view the product categories screen if not already taken out
		Given user is on the XX screen
		When user clicks on the Product Selection link
		Then verify product selection header as "Do you want to add an extra products or services?" on screen
		
	Scenario: Product Selection >> CUICE-540 >> TC-002: Test the content on the "Product Selection" screen
		Given user is on Product Selection screen
		Then verify product selection header as "Do you want to add an extra products or services?" on screen
		Then verify icon displayed on screen
		Then verify product name as "Business Overdrafts" on screen
		Then verify product benefit as "Best for flexible access to cash flow" on screen
		Then verify link "Find out more" on screen
		Then verify apply as "Apply" on screen
		Then verify skip as "Skip" on screen
	
	Scenario: Product Selection >> CUICE-540 >> TC-003: Test if user is taken back to "Lending Question" screen after Apply is clicked
		Given user is on Product Selection screen
		When user clicks on Apply button
		Then verify lending question screen is displayed
	
	Scenario: Product Selection >> CUICE-540 >> TC-004: Test if user is taken back to "XX" screen after Skip is clicked
		Given user is on the XX screen
		Given user is on Product Selection screen
		When user clicks on Skip button
		Then verify that XX screen is displayed
		
	Scenario: Product Selection >> CUICE-542 >> TC-001: Test if user is taken to "Product Details" screen after find out more is clicked
		Given user is on Product Selection screen
		When user clicks on find out more link
		Then verify product name "Business Overdraft" on Product Details screen
	
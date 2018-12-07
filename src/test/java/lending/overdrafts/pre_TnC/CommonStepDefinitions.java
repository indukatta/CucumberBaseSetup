package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.MobileDriverManager.*;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Login.Login;
import pageObjects.More.More;

public class CommonStepDefinitions extends CommonLibrary {
	
	public static String continueButton;

	@Before
	public void startTestReport(Scenario scenario) throws Exception {
		startTest(scenario.getName());
	}

	@After
	public void endTestReport(Scenario scenario) {
		endTest();
	}

	@Given("^that user is on the Credit Management screen$")
	public static void that_user_is_on_the_Credit_Management_screen() throws Throwable {
		setStepName("Given");
		if (!alreadyLoggedIn) {
			Login login = new Login(driver);
			login.loginAsUser("TESTUSER", "TESTPASSWORD");
			
//			login.loginAsUser("Testuser", "testuser");
//			findByAccessibilityId("Cancel").click();
			
			alreadyLoggedIn = true;
		}else {
			reportPass("User is already logged in to Iceberg application.");
		}
	}
	
	@When("^user clicks on the Credit & Lending link$")
	public static void user_clicks_on_the_Credit_and_Lending_link() throws Throwable {
		setStepName("When");
		More more = new More(driver);
		more.navigateToCreditAndLending();
		sleep(3000);
	}
	
	@Given("^that category \"([^\"]*)\" is added for below scenarios$")
	public void that_category_is_added_for_below_sceanios(String category) {
		addTestCategory(category);
	}

	@When("^user clicks on continue button on the screen$")
	public void user_clicks_on_continue_button_on_the_screen() throws Throwable {
		setStepName("When");
		findByAny(continueButton).click();
		sleep(3000);
	}

	@Then("^verify that continue button is enabled$")
	public void verify_that_continue_button_is_enabled() throws Throwable {
		setStepName("Then");
		captureScreenshot();
		findByAny(continueButton).isEnabled();
	}

	@Then("^verify that continue button is disabled$")
	public void verify_that_continue_button_is_disabled() {
		setStepName("Then");
		captureScreenshot();
		findByAny(continueButton).isDisabled();
	}
	
	@Then("^verify that Yes button is displayed on lending question screen$")
	public void verify_that_Yes_button_is_displayed_on_lending_question_screen() {
		
	}

	@Then("^verify that No button is displayed on lending question screen$")
	public void verify_that_No_button_is_displayed_on_lending_question_screen() {
		
	}

	@Then("^verify that Yes button is not selected on lending question screen$")
	public void verify_that_Yes_button_is_not_selected_on_lending_question_screen() {
		
	}

	@Then("^verify that No button is not selected on lending question screen$")
	public void verify_that_No_button_is_not_selected_on_lending_question_screen() {
		
	}

	@When("^user clicks on No button on lending question screen$")
	public void user_clicks_on_No_button_on_lending_question_YesNo_screen() {
		
	}

	@When("^user clicks on Yes button on lending question screen$")
	public void user_clicks_on_Yes_button_on_lending_question_YesNo_screen() {

	}
	@Then("^user clicks on back button on lending question screen$")
	public void user_clicks_on_back_button_on_lending_question_screen() {
		
	}
}

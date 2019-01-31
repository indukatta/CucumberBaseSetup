package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.findByAny;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TermsAndConditions {
	public static String tncHeader;
	public static String tncContent;
	public static String tncAccept;
	public static String tncReject;
	public static String processingInfo;
	public static String inProgress;
	
	@Then("^verify that Terms and Conditions screen is displayed$")
	public void verify_that_Total_Existing_Borrowings_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot("TermsAndConditions");
		findByAny(tncHeader).isDisplayed();
		findByAny(tncAccept).isDisplayed();
	}
	
	@Given("^verify that user is on Proccessing you Application screen$")
	public void that_user_is_on_Business_Premises_options_screen() {
		setStepName("Given");
		findByAny(inProgress).isDisplayed();
		findByAny(processingInfo).isDisplayed();
	}
	
	@Given("^that user is on the Terms and Conditions screen$")
	public void that_user_is_on_the_Terms_and_Conditions_screen() {
		
	}

	@Then("^verify that Accept button is not visible$")
	public void verify_that_Accept_button_is_not_visible() {
		
	}

	@Then("^verify that Reject button is not visible$")
	public void verify_that_Reject_button_is_not_visible() {
		
	}

	@When("^user scroll down to bottom of screen$")
	public void user_scroll_down_to_bottom_of_screen() {
		
	}

	@Then("^verify that help link is visible on screen$")
	public void verify_that_help_link_is_visible_on_screen() {
		
	}

	@Then("^verify that url \"([^\"]*)\" is linked to the help text$")
	public void verify_that_url_is_linked_to_the_help_text(String arg1) {
		
	}

	@Then("^verify that Accept button is enabled on screen$")
	public void verify_that_Accept_button_is_enabled_on_screen() {
		
	}

	@Then("^verify that Reject button is enabled on screen$")
	public void verify_that_Reject_button_is_enabled_on_screen() {
		
	}

	@When("^user clicks on Reject button on Terms and Conditions screen$")
	public void user_clicks_on_Reject_button_on_Terms_and_Conditions_screen() {
		
	}

	@Then("^verify that confirmation Alert is pops up on screen$")
	public void verify_that_confirmation_Alert_is_pops_up_on_screen() {
		
	}

	@When("^user clicks on No to dissmiss the alret$")
	public void user_clicks_on_No_to_dissmiss_the_alret() {
		
	}

	@When("^user clicks on Yes to accept the alret$")
	public void user_clicks_on_Yes_to_accept_the_alret() {
		
	}
}

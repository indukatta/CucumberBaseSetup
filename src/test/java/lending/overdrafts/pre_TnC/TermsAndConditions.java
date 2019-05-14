package lending.overdrafts.pre_TnC;

import static com.factory.mobile.driver.AppiumDriverManager.captureScreenshot;
import static com.factory.mobile.driver.AppiumDriverManager.findByAny;
import static com.factory.mobile.driver.AppiumDriverManager.setStepName;
import static com.factory.mobile.driver.AppiumDriverManager.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lending.common.library.CommonLibrary;

public class TermsAndConditions extends CommonLibrary {
	public static String screenTitle;
	public static String tncHeader;
	public static String tncContent;
	public static String tncReject;
	public static String processingInfo;
	public static String inProgress;
	public static String clickHere;

	@Then("^verify that Terms and Conditions screen is displayed$")
	public void verify_that_Terms_and_Conditions_screen_is_displayed() {
		setStepName("Then");
		captureScreenshot();
//		findByAny(screenTitle).isDisplayed();
	}

	@When("^user clicks on Accept button on Terms and Conditions screen$")
	public void user_clicks_on_Accept_button_on_Terms_and_Conditions_screen() {
		setStepName("When");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("Accept").scrollDownUntilVisible().click();
		sleep(3000);
	}

	@Then("^verify that Processing your Application screen is displayed$")
	public void verify_that_Processing_your_Application_screen_is_displayed() {
		setStepName("Then");
		findByAny(processingInfo).isDisplayed();
	}
	
	@Then("^wait for Processing your Application screen to disappear$")
	public void wait_for_Processing_your_Application_screen_to_disappear() {
		setStepName("Then");
		findByAny(processingInfo).waitTillVisible();
	}

	@Given("^verify that user is on Proccessing your Application screen$")
	public void verify_that_user_is_on_Proccessing_your_Application_screen() {
		setStepName("Given");
		findByAny(inProgress).isDisplayed();
		findByAny(processingInfo).isDisplayed();
	}

	@Given("^that user is on the Terms and Conditions screen$")
	public void that_user_is_on_the_Terms_and_Conditions_screen() {
		setStepName("Given");
		findByAny(screenTitle).isDisplayed();
	}

	@Then("^verify that Accept button is not visible$")
	public void verify_that_Accept_button_is_not_visible() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("Accept").verifyAttributesEqualsTo("visible", "false");
	}

	@Then("^verify that Reject button is not visible$")
	public void verify_that_Reject_button_is_not_visible() {
		setStepName("Then");
		findByAny(tncReject).verifyAttributesEqualsTo("visible", "false");
	}

	@When("^user scroll down to bottom of screen$")
	public void user_scroll_down_to_bottom_of_screen() {
		setStepName("Then");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("Accept").scrollDownUntilVisible();
	}

	@Then("^verify that click here link is visible on screen$")
	public void verify_that_click_here_link_is_visible_on_screen() {
		setStepName("Then");
		captureScreenshot();
		findByAny(clickHere).isDisplayed();
	}

	@Then("^verify that url \"([^\"]*)\" is linked to click here$")
	public void verify_that_url_is_linked_to_the_help_text(String arg1) {
		setStepName("Then");
		findByAny(clickHere).verifyAttributesEqualsTo("href", arg1);
	}

	@Then("^verify that Accept button is pre selected and enabled$")
	public void verify_that_Accept_button_is_pre_selected_and_enabled() {
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("Accept").verifyAttributesEqualsTo("value", "1");
		findByAny(CommonStepDefinitions.lendingPrimaryButton).as("Accept").isEnabled();
	}

	@Then("^verify that Reject button is not pre selected and enabled$")
	public void verify_that_Reject_button_is_not_pre_selected_and_enabled() {
		setStepName("Then");
		findByAny(tncReject).verifyAttributesEqualsTo("value", "0");
		findByAny(tncReject).isEnabled();
	}

	@When("^user clicks on Reject button on Terms and Conditions screen$")
	public void user_clicks_on_Reject_button_on_Terms_and_Conditions_screen() {
		setStepName("Then");
		findByAny(tncReject).scrollDownUntilVisible().click();
		sleep(3000);
	}

	@When("^user clicks on No on Alert pop up to dismiss$")
	public void user_clicks_on_No_on_Alert_pop_up_to_dismiss() {
		setStepName("Then");
		application().alertAccept();
	}

	@When("^user clicks on Yes on Alert pop up to dismiss$")
	public void user_clicks_on_Yes_on_Alert_pop_up_to_dismiss() {
		setStepName("Then");
		application().alertDismiss();
	}
}

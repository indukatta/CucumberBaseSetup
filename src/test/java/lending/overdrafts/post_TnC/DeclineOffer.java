package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lending.overdrafts.pre_TnC.CommonLibrary;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class DeclineOffer extends CommonLibrary {
	public static String alertImageView;
	public static String alertTitleLabel;
	public static String alertBodyLabel;
	public static String alertYesButton;
	public static String alertNoButton;

	@Then("^verify that Decline Offer screen is visible$")
	public void verify_that_Decline_Offer_screen_is_visible() {
		setStepName("Then");
		captureScreenshot();
		findByAny(alertImageView).isDisplayed();
	}

	@Given("^that user is on the Decline Offer screen$")
	public void that_user_is_on_the_Decline_Offer_screen() {
		setStepName("Given");
		findByAny(alertImageView).isDisplayed();
	}

	@Then("^verify that Decline Offer title text \"([^\"]*)\" is displayed$")
	public void verify_that_Decline_Offer_title_text_is_displayed(String expected) {
		setStepName("Then");
		findByAny(alertTitleLabel).verifyEqualsTo(expected);
	}

	@Then("^verify that Decline Offer body text \"([^\"]*)\" is displayed$")
	public void verify_that_Decline_Offer_body_text_is_displayed(String expected) {
		setStepName("Then");
		findByAny(alertBodyLabel).verifyEqualsTo(expected);
	}

	@Then("^click on No button on Decline Offer screen$")
	public void click_on_No_button_on_Decline_Offer_screen() {
		setStepName("Then");
		findByAny(alertYesButton).click();
		sleep(1000);
	}

	@Then("^click on Yes button on Decline Offer screen$")
	public void click_on_Yes_button_on_Decline_Offer_screen() {
		setStepName("Then");
		findByAny(alertNoButton).click();
	}

	@Then("^verify that User Decline screen is displayed$")
	public void verify_that_User_Decline_screen_is_displayed() {
		setStepName("Then");
	}

	@Then("^verify that No button is displayed on Decline Offer screen$")
	public void verify_that_No_button_is_displayed_on_Decline_Offer_screen() {
		setStepName("Then");
		findByAny(alertNoButton).isDisplayed();
	}

	@Then("^verify that Yes button is displayed on Decline Offer screen$")
	public void verify_that_Yes_button_is_displayed_on_Decline_Offer_screen() {
		setStepName("Then");
		findByAny(alertYesButton).isDisplayed();
	}

}

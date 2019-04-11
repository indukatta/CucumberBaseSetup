package lending.overdrafts.post_TnC;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lending.common.library.CommonLibrary;

import static com.factory.mobile.driver.AppiumDriverManager.*;

public class DeclineOffer extends CommonLibrary {
	public static String alertImageView;
	public static String alertTitleLabel;
	public static String alertBodyLabel;
	public static String alertPrimaryButton;
	public static String alertSecondaryButton;

	@Then("^verify that Decline Offer screen is visible$")
	public void verify_that_Decline_Offer_screen_is_visible() {
		setStepName("Then");
		captureScreenshot();
		findByAny(alertTitleLabel).isDisplayed();
	}

	@Given("^that user is on the Decline Offer screen$")
	public void that_user_is_on_the_Decline_Offer_screen() {
		setStepName("Given");
		findByAny(alertTitleLabel).isDisplayed();
	}

	@Then("^verify that Decline Offer alert image is displayed$")
	public void verify_that_Decline_Offer_alert_image_is_displayed() {
		setStepName("Then");
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

	@Then("^user clicks on No button on Decline Offer screen$")
	public void click_on_No_button_on_Decline_Offer_screen() {
		setStepName("Then");
		findByAny(alertPrimaryButton).as("No Button").click();
		sleep(1000);
	}

	@Then("^user clicks on Yes button on Decline Offer screen$")
	public void click_on_Yes_button_on_Decline_Offer_screen() {
		setStepName("Then");
		findByAny(alertSecondaryButton).as("Yes Button").click();
		sleep(2000);
	}

	@Then("^verify that No button is displayed on Decline Offer screen$")
	public void verify_that_No_button_is_displayed_on_Decline_Offer_screen() {
		setStepName("Then");
		findByAny(alertSecondaryButton).as("No Button").isDisplayed();
	}

	@Then("^verify that Yes button is displayed on Decline Offer screen$")
	public void verify_that_Yes_button_is_displayed_on_Decline_Offer_screen() {
		setStepName("Then");
		findByAny(alertPrimaryButton).as("Yes Button").isDisplayed();
	}

}
